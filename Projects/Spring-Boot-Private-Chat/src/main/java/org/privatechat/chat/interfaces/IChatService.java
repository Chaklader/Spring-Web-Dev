package org.privatechat.chat.interfaces;

import java.util.List;
import org.privatechat.chat.DTOs.ChatChannelInitializationDTO;
import org.privatechat.chat.DTOs.ChatMessageDTO;
import org.privatechat.user.exceptions.IsSameUserException;
import org.privatechat.user.exceptions.UserNotFoundException;
import org.springframework.beans.BeansException;

public interface IChatService {
  String establishChatSession(ChatChannelInitializationDTO chatChannelInitializationDTO)
      throws IsSameUserException, BeansException, UserNotFoundException;

  void submitMessage(ChatMessageDTO chatMessageDTO)
      throws BeansException, UserNotFoundException;
  
  List<ChatMessageDTO> getExistingChatMessages(String channelUuid);
}