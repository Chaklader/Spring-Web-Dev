package org.privatechat.user.interfaces;

import java.util.List;
import org.privatechat.shared.exceptions.ValidationException;
import org.privatechat.user.DTOs.NotificationDTO;
import org.privatechat.user.DTOs.RegistrationDTO;
import org.privatechat.user.DTOs.UserDTO;
import org.privatechat.user.exceptions.UserNotFoundException;
import org.privatechat.user.models.User;
import org.springframework.beans.BeansException;
import org.springframework.security.core.context.SecurityContext;

public interface IUserService {
  User getUser(String userEmail)
      throws BeansException, UserNotFoundException;

  User getUser(long userId)
      throws BeansException, UserNotFoundException;

  User getUser(SecurityContext securityContext)
      throws BeansException, UserNotFoundException;

  boolean doesUserExist(String email);

  void addUser(RegistrationDTO registrationDTO)
      throws ValidationException;

  List<UserDTO> retrieveFriendsList(User user);

  UserDTO retrieveUserInfo(User user);

  void setIsPresent(User user, Boolean stat);

  Boolean isPresent(User user);

  void notifyUser(User user, NotificationDTO notification);
}