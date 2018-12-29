package org.privatechat.user.services;

import org.privatechat.shared.exceptions.ValidationException;
import org.privatechat.user.DTOs.NotificationDTO;
import org.privatechat.user.DTOs.RegistrationDTO;
import org.privatechat.user.DTOs.UserDTO;
import org.privatechat.user.exceptions.UserNotFoundException;
import org.privatechat.user.interfaces.IUserService;
import org.privatechat.user.mappers.UserMapper;
import org.privatechat.user.models.User;
import org.privatechat.user.repositories.UserRepository;
import org.privatechat.user.strategies.*;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import javax.validation.ConstraintViolationException;
import java.util.List;

@Component
public class UserService implements UserDetailsService, IUserService {
  private UserRepository userRepository;

  @Autowired
  private SimpMessagingTemplate simpMessagingTemplate;
  
  @Autowired
  private BeanFactory beanFactory;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  private <T> User getUser(T userIdentifier, IUserRetrievalStrategy<T> strategy)
      throws UserNotFoundException {
    User user = strategy.getUser(userIdentifier);

    if (user == null) { throw new UserNotFoundException("User not found."); }

    return user;
  }

  public User getUser(long userId)
      throws BeansException, UserNotFoundException {
    return this.getUser(userId, beanFactory.getBean(UserRetrievalByIdStrategy.class));
  }

  public User getUser(String userEmail)
      throws BeansException, UserNotFoundException {
    return this.getUser(userEmail, beanFactory.getBean(UserRetrievalByEmailStrategy.class));
  }

  public User getUser(SecurityContext userSecurityContext)
      throws BeansException, UserNotFoundException {
    return this.getUser(userSecurityContext, beanFactory.getBean(UserRetrievalBySecurityContextStrategy.class));
  }

  @Override
  public UserDetails loadUserByUsername(String email) {
    User user = userRepository.findByEmail(email);

    if (user == null) { return null; }

    UserDetails userDetails = new org.springframework.security.core.userdetails.User(
      user.getEmail(),
      user.getPassword(),
      AuthorityUtils.createAuthorityList(user.getRole())
    );

    Authentication authentication = null;
    try {
      authentication = new UsernamePasswordAuthenticationToken(
        userDetails,
        null,
        userDetails.getAuthorities()
      );
    } catch (Exception e) {}

    SecurityContextHolder
      .getContext()
      .setAuthentication(authentication);

    return userDetails;
  }

  public boolean doesUserExist(String email) {
    User user = userRepository.findByEmail(email);

    return user != null;
  }

  public void addUser(RegistrationDTO registrationDTO)
      throws ValidationException {
    if (this.doesUserExist(registrationDTO.getEmail())) {
      throw new ValidationException("User already exists.");
    }

    String encryptedPassword = new BCryptPasswordEncoder().encode(registrationDTO.getPassword());

    try {
      User user = new User(
        registrationDTO.getEmail(),
        registrationDTO.getFullName(),
        encryptedPassword,
        "STANDARD-ROLE"
      );
 
      userRepository.save(user);
    } catch (ConstraintViolationException e) {
      throw new ValidationException(e.getConstraintViolations().iterator().next().getMessage());
    }
  }

  public List<UserDTO> retrieveFriendsList(User user) {
    List<User> users = userRepository.findFriendsListFor(user.getEmail());

    return UserMapper.mapUsersToUserDTOs(users);
  }
  
  public UserDTO retrieveUserInfo(User user) {
    return new UserDTO(
      user.getId(),
      user.getEmail(),
      user.getFullName()
    );
  }

  // TODO: switch to a TINYINT field called "numOfConnections" to add/subtract
  // the total amount of user connections
  public void setIsPresent(User user, Boolean stat) {
    user.setIsPresent(stat);

    userRepository.save(user);
  }

  public Boolean isPresent(User user) {
    return user.getIsPresent(); 
  }

  public void notifyUser(User recipientUser, NotificationDTO notification) {
    if (this.isPresent(recipientUser)) {
      simpMessagingTemplate
        .convertAndSend("/topic/user.notification." + recipientUser.getId(), notification);
    } else {
      System.out.println("sending email notification to " + recipientUser.getFullName());
      // TODO: send email
    }
  }
}