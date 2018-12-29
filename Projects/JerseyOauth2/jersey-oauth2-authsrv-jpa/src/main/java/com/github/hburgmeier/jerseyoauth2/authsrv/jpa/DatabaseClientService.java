package com.github.hburgmeier.jerseyoauth2.authsrv.jpa;

import java.util.Set;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.hburgmeier.jerseyoauth2.api.user.IUser;
import com.github.hburgmeier.jerseyoauth2.authsrv.api.IConfiguration;
import com.github.hburgmeier.jerseyoauth2.authsrv.api.client.ClientServiceException;
import com.github.hburgmeier.jerseyoauth2.authsrv.api.client.ClientType;
import com.github.hburgmeier.jerseyoauth2.authsrv.api.client.IAuthorizedClientApp;
import com.github.hburgmeier.jerseyoauth2.authsrv.api.client.IClientIdGenerator;
import com.github.hburgmeier.jerseyoauth2.authsrv.api.client.IClientService;
import com.github.hburgmeier.jerseyoauth2.authsrv.api.client.IPendingClientToken;
import com.github.hburgmeier.jerseyoauth2.authsrv.api.client.IRegisteredClientApp;
import com.github.hburgmeier.jerseyoauth2.authsrv.api.token.ITokenGenerator;
import com.github.hburgmeier.jerseyoauth2.authsrv.api.token.TokenGenerationException;
import com.github.hburgmeier.jerseyoauth2.authsrv.api.user.IUserStorageService;
import com.github.hburgmeier.jerseyoauth2.authsrv.api.user.UserStorageServiceException;

public class DatabaseClientService implements IClientService {

	private static final String PERSISTENCE_ERROR = "persistence error - rollback";

	private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseClientService.class);
	
	private final EntityManagerFactory emf;
	
	@com.google.inject.Inject(optional=true)
	private IUserStorageService userStorageService = null;
	
	private final ITokenGenerator tokenGenerator;
	private final IClientIdGenerator clientIdGenerator;
	private final IConfiguration configuration;

	@Inject
	public DatabaseClientService(EntityManagerFactory emf, ITokenGenerator tokenGenerator, final IClientIdGenerator clientIdGenerator,
			final IConfiguration configuration)
	{
		this.emf = emf;
		this.tokenGenerator = tokenGenerator;
		this.clientIdGenerator = clientIdGenerator;
		this.configuration = configuration;
		
	}
	
	@Override
	public IRegisteredClientApp registerClient(String appName, String callbackUrl, ClientType clientType) throws ClientServiceException {
		String clientId = clientIdGenerator.generateClientId();
		String clientSecret = null;
		if (clientType != ClientType.PUBLIC ||
			  configuration.getGenerateSecretForPublicClients())
		{
			clientSecret = clientIdGenerator.generateClientSecret();
		}

		RegisteredClient client = new RegisteredClient(clientId, clientSecret);
		client.setApplicationName(appName);
		client.setCallbackUrl(callbackUrl);
		client.setClientType(clientType);
		persist(client);
		LOGGER.debug("registered client {}", clientId);
		return client;
	}

	@Override
	public IRegisteredClientApp getRegisteredClient(String clientId) {
		EntityManager entityManager = emf.createEntityManager();
		try {
			return entityManager.find(RegisteredClient.class, clientId);
		} finally {
			entityManager.close();
		}
	}

	@Override
	public IAuthorizedClientApp authorizeClient(IUser user, IRegisteredClientApp clientApp, Set<String> allowedScopes)
			throws ClientServiceException {
		assert(clientApp instanceof RegisteredClient);
		
		EntityManager entityManager = emf.createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		try {
		
			AuthorizedClientApplication clApp = findAuthorizedClient(user, clientApp.getClientId(), entityManager);
		
			if (clApp == null)
			{
				clApp = new AuthorizedClientApplication((RegisteredClient)clientApp, user, allowedScopes);
			} else {
				entityManager.merge(clApp);
				clApp.setScopes(allowedScopes);
			}
			try {
				tx.begin();
				entityManager.persist(clApp);
				entityManager.flush();
				tx.commit();
			} catch (PersistenceException e) {
				LOGGER.error(PERSISTENCE_ERROR, e);
				tx.rollback();
				throw e;
			}
			return clApp;
		} finally {
			entityManager.close();			
		}
	}

	@Override
	public IAuthorizedClientApp isAuthorized(IUser user, String clientId, Set<String> scopes) {
		EntityManager entityManager = emf.createEntityManager();
		try {
			AuthorizedClientApplication result = findAuthorizedClient(user, clientId, entityManager);
			
			if (result == null)
				return null;
			
			if (!result.getAuthorizedScopes().containsAll(scopes))
			{
				LOGGER.debug("scopes do not match authorized scopes {} auth {}", scopes, result.getAuthorizedScopes());
				return null;
			}
			
			setUser(result);			
			return result;
		} catch (UserStorageServiceException e) {
			return null;
		} finally {
			entityManager.close();			
		}
	}

	protected AuthorizedClientApplication findAuthorizedClient(IUser user, String clientId, EntityManager entityManager) {
		
		try {
			TypedQuery<AuthorizedClientApplication> query = entityManager.createNamedQuery("findAuthorizedClient", AuthorizedClientApplication.class);
			query.setParameter("username", user.getName());
			query.setParameter("clientId", clientId);
			AuthorizedClientApplication result = query.getSingleResult();
			return result;
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public IPendingClientToken createPendingClientToken(IAuthorizedClientApp clientApp) throws ClientServiceException {
		assert(clientApp instanceof AuthorizedClientApplication);
		
		try {
			String code = tokenGenerator.createAuthenticationCode();
			PendingClientToken pendingClientAuth = new PendingClientToken((AuthorizedClientApplication) clientApp, code);
			persist(pendingClientAuth);
			return pendingClientAuth;
		} catch (TokenGenerationException e) {
			LOGGER.error("Error creating authorization code", e);
			throw new ClientServiceException(e);
		}
	}
	
	@Override
	public IPendingClientToken findPendingClientToken(String clientId, String clientSecret, String code) {
		EntityManager entityManager = emf.createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		try {
			TypedQuery<PendingClientToken> query = entityManager.createNamedQuery("findPendingByCode", PendingClientToken.class);
			query.setParameter("code", code);
			query.setParameter("clientId", clientId);
			query.setParameter("clientSecret", clientSecret);
			PendingClientToken result = query.getSingleResult();
			try {
				tx.begin();
				entityManager.remove(result);
				tx.commit();
			} catch (PersistenceException e) {
				LOGGER.error(PERSISTENCE_ERROR, e);
				tx.rollback();
				result = null;
			}
			setUser((AuthorizedClientApplication)result.getAuthorizedClient());
			return result;
		} catch (NoResultException e) {
			return null;
		} catch (UserStorageServiceException e) {
			return null;
		} finally {
			entityManager.close();
		}
	}
	
	@Override
	public void removePendingClientToken(IPendingClientToken pendingClientToken) {
		EntityManager entityManager = emf.createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		try {
			tx.begin();
			IPendingClientToken dbPendingClientToken = entityManager.merge(pendingClientToken);
			entityManager.remove(dbPendingClientToken);
			tx.commit();
		} catch (PersistenceException e) {
			LOGGER.error(PERSISTENCE_ERROR, e);
			tx.rollback();
			throw e;			
		} finally {
			entityManager.close();
		}		
	}
	
	@Override
	public void removePendingTokensForUser(IUser user) {
		EntityManager entityManager = emf.createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		try {
			tx.begin();
			TypedQuery<PendingClientToken> query = entityManager.createNamedQuery("findPendingByUser", PendingClientToken.class);
			query.setParameter("username", user.getName());
			for (PendingClientToken token : query.getResultList())
			{
				entityManager.remove(token);
			}
			tx.commit();
		} catch (PersistenceException e) {
			LOGGER.error(PERSISTENCE_ERROR, e);
			tx.rollback();
			throw e;			
		} finally {
			entityManager.close();
		}		
	}
	
	protected void persist(Object obj) {
		EntityManager entityManager = emf.createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		try {
			tx.begin();
			entityManager.persist(obj);
			entityManager.flush();
			tx.commit();
		} catch (PersistenceException e) {
			LOGGER.error(PERSISTENCE_ERROR, e);
			tx.rollback();
			throw e;
		} finally {
			entityManager.close();
		}
	}
	
	protected void setUser(AuthorizedClientApplication result) throws UserStorageServiceException {
		if (userStorageService!=null)
		{
			LOGGER.debug("using userStorageService to load user");
			IUser iUser = userStorageService.loadUser(result.getUsername());
			result.setAuthorizedUser(iUser);
		}
		else {
			LOGGER.debug("using no user storage service");
			result.setAuthorizedUser(new User(result.getUsername()));
		}
	}
	
}
