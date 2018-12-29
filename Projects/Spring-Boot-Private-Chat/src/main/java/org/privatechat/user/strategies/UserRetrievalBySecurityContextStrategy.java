package org.privatechat.user.strategies;

import org.privatechat.user.models.User;
import org.privatechat.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Service;

@Service
public class UserRetrievalBySecurityContextStrategy implements IUserRetrievalStrategy<SecurityContext> {
  private UserRepository userRepository;

  @Autowired
  public UserRetrievalBySecurityContextStrategy(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public User getUser(SecurityContext securityContext) {
    org.springframework.security.core.userdetails.User userFromSecurityContext;

    userFromSecurityContext = (org.springframework.security.core.userdetails.User)
      securityContext.getAuthentication().getPrincipal();

    return userRepository.findByEmail(userFromSecurityContext.getUsername());
  }
}