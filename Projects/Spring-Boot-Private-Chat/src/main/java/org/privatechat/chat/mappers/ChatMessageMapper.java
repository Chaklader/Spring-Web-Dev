package org.privatechat.chat.mappers;

import java.util.ArrayList;
import java.util.List;
import org.privatechat.chat.DTOs.ChatMessageDTO;
import org.privatechat.chat.models.ChatMessage;
import org.privatechat.user.models.User;

public class ChatMessageMapper {
  public static List<ChatMessageDTO> mapMessagesToChatDTOs(List<ChatMessage> chatMessages) {
    List<ChatMessageDTO> dtos = new ArrayList<ChatMessageDTO>();

    for(ChatMessage chatMessage : chatMessages) { 
      dtos.add(
        new ChatMessageDTO(
          chatMessage.getContents(),
          chatMessage.getAuthorUser().getId(),
          chatMessage.getRecipientUser().getId()
        )
      );
    }

    return dtos;
  }

  public static ChatMessage mapChatDTOtoMessage(ChatMessageDTO dto) {
    return new ChatMessage(

      // only need the id for mapping
      new User(dto.getFromUserId()),
      new User(dto.getToUserId()),

      dto.getContents()
    );
  }
}
