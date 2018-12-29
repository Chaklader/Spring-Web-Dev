package org.privatechat.user.strategies;

import org.privatechat.user.models.User;
import org.privatechat.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRetrievalByIdStrategy implements IUserRetrievalStrategy<Long> {
  private UserRepository userRepository;

  @Autowired
  public UserRetrievalByIdStrategy(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public User getUser(Long userIdentifier) {
    return userRepository.findById(userIdentifier);
  }
}
