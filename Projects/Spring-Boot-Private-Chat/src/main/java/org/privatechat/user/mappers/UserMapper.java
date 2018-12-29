package org.privatechat.user.mappers;

import java.util.ArrayList;
import java.util.List;
import org.privatechat.user.DTOs.UserDTO;
import org.privatechat.user.models.User;

public class UserMapper {
  public static List<UserDTO> mapUsersToUserDTOs(List<User> users) {
    List<UserDTO> dtos = new ArrayList<UserDTO>();

    for(User user : users) {
      dtos.add(
        new UserDTO(
          user.getId(),
          user.getEmail(),
          user.getFullName()
        )
      );
    }

    return dtos;
  }
}