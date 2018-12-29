package org.privatechat.user.strategies;

import org.privatechat.user.models.User;
import org.privatechat.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRetrievalByEmailStrategy implements IUserRetrievalStrategy<String> {
  private UserRepository userRepository;

  @Autowired
  public UserRetrievalByEmailStrategy(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public User getUser(String userIdentifier) {
    return userRepository.findByEmail(userIdentifier);
  }
}