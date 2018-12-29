package org.privatechat.chat.services;

import org.privatechat.chat.DTOs.ChatChannelInitializationDTO;
import org.privatechat.chat.DTOs.ChatMessageDTO;
import org.privatechat.chat.interfaces.IChatService;
import org.privatechat.chat.mappers.ChatMessageMapper;
import org.privatechat.chat.models.ChatChannel;
import org.privatechat.chat.models.ChatMessage;
import org.privatechat.chat.repositories.ChatChannelRepository;
import org.privatechat.chat.repositories.ChatMessageRepository;
import org.privatechat.user.DTOs.NotificationDTO;
import org.privatechat.user.exceptions.IsSameUserException;
import org.privatechat.user.exceptions.UserNotFoundException;
import org.privatechat.user.models.User;
import org.privatechat.user.services.UserService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.google.common.collect.Lists;
import java.util.List;

@Service
public class ChatService implements IChatService {
  private ChatChannelRepository chatChannelRepository;

  private ChatMessageRepository chatMessageRepository;

  private UserService userService;
  
  private final int MAX_PAGABLE_CHAT_MESSAGES = 100;

  @Autowired
  public ChatService(
      ChatChannelRepository chatChannelRepository,
      ChatMessageRepository chatMessageRepository,
      UserService userService) {
    this.chatChannelRepository = chatChannelRepository;
    this.chatMessageRepository = chatMessageRepository;
    this.userService = userService;
  }

  private String getExistingChannel(ChatChannelInitializationDTO chatChannelInitializationDTO) {
    List<ChatChannel> channel = chatChannelRepository
      .findExistingChannel(
        chatChannelInitializationDTO.getUserIdOne(),
        chatChannelInitializationDTO.getUserIdTwo()
      );
    
    return (channel != null && !channel.isEmpty()) ? channel.get(0).getUuid() : null;
  }

  private String newChatSession(ChatChannelInitializationDTO chatChannelInitializationDTO)
      throws BeansException, UserNotFoundException {
    ChatChannel channel = new ChatChannel(
      userService.getUser(chatChannelInitializationDTO.getUserIdOne()),
      userService.getUser(chatChannelInitializationDTO.getUserIdTwo())
    );
    
    chatChannelRepository.save(channel);

    return channel.getUuid();
  }

  public String establishChatSession(ChatChannelInitializationDTO chatChannelInitializationDTO)
      throws IsSameUserException, BeansException, UserNotFoundException {
    if (chatChannelInitializationDTO.getUserIdOne() == chatChannelInitializationDTO.getUserIdTwo()) {
      throw new IsSameUserException();
    }

    String uuid = getExistingChannel(chatChannelInitializationDTO);

    // If channel doesn't already exist, create a new one
    return (uuid != null) ? uuid : newChatSession(chatChannelInitializationDTO);
  }
  
  public void submitMessage(ChatMessageDTO chatMessageDTO)
      throws BeansException, UserNotFoundException {
    ChatMessage chatMessage = ChatMessageMapper.mapChatDTOtoMessage(chatMessageDTO);

    chatMessageRepository.save(chatMessage);

    User fromUser = userService.getUser(chatMessage.getAuthorUser().getId());
    User recipientUser = userService.getUser(chatMessage.getRecipientUser().getId());
      
    userService.notifyUser(recipientUser,
      new NotificationDTO(
        "ChatMessageNotification",
        fromUser.getFullName() + " has sent you a message",
        chatMessage.getAuthorUser().getId()
      )
    );
  }
 
  public List<ChatMessageDTO> getExistingChatMessages(String channelUuid) {
    ChatChannel channel = chatChannelRepository.getChannelDetails(channelUuid);

    List<ChatMessage> chatMessages = 
      chatMessageRepository.getExistingChatMessages(
        channel.getUserOne().getId(),
        channel.getUserTwo().getId(),
        new PageRequest(0, MAX_PAGABLE_CHAT_MESSAGES)
      );

    // TODO: fix this
    List<ChatMessage> messagesByLatest = Lists.reverse(chatMessages); 

    return ChatMessageMapper.mapMessagesToChatDTOs(messagesByLatest);
  }
}