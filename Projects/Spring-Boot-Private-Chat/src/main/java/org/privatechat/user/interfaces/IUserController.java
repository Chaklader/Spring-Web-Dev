package org.privatechat.user.interfaces;

import java.security.Principal;
import org.privatechat.shared.exceptions.ValidationException;
import org.privatechat.user.DTOs.RegistrationDTO;
import org.privatechat.user.exceptions.UserNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface IUserController {
  ResponseEntity<String> register(@RequestBody RegistrationDTO registeringUser)
      throws ValidationException;

  ResponseEntity<String> retrieveRequestingUserFriendsList(Principal principal)
      throws UserNotFoundException;

  ResponseEntity<String> retrieveRequestUserInfo()
      throws UserNotFoundException;
}
