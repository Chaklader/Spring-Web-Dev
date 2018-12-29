package com.mohsenj.module.user.service;

import com.mohsenj.core.lib.exception.UserAlreadyExistException;
import com.mohsenj.module.user.model.User;
import com.mohsenj.module.user.model.VerificationToken;
import com.mohsenj.module.user.repository.RoleRepository;
import com.mohsenj.module.user.repository.UserRepository;
import com.mohsenj.module.user.repository.VerificationTokenRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Autowired
    private VerificationTokenRepository tokenRepository;

    /*
    @Override
    public User register(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        userRepository.save(user);
        
        return user;
    }*/
    

    
    @Override
    public User registerNewUserAccount(final User accountDto) {
        if (emailExist(accountDto.getEmail())) {
            throw new UserAlreadyExistException("There is an account with that email adress: " + accountDto.getEmail());
        }
        final User user = new User();

       // user.setFirstName(accountDto.getFirstName());
      //  user.setLastName(accountDto.getLastName());
        user.setPassword(bCryptPasswordEncoder.encode(accountDto.getPassword()));
        user.setEmail(accountDto.getEmail());
      //  user.setUsing2FA(accountDto.isUsing2FA());
        user.setRoles(new HashSet<>(Arrays.asList(roleRepository.findByName("normal_user"))));
        return userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

	@Override
	public User findUserAndRolesByUserId(long userId) {
		return userRepository.findUserAndRolesByUserId(userId);
	}

	@Override
	public void createVerificationTokenForUser(User user, String token) {
		VerificationToken myToken = new VerificationToken(token, user);
        tokenRepository.save(myToken);
		
	}
	
	@Override
    public VerificationToken getVerificationToken(String VerificationToken) {
        return tokenRepository.findByToken(VerificationToken);
    }
	
	@Override
    public void saveRegisteredUser(User user) {
		userRepository.save(user);
    }
	
	private boolean emailExist(String email) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            return true;
        }
        return false;
    }

	@Override
	public User findUserByEmail(final String email) {
		return userRepository.findByEmail(email);
	}
}
