package org.privatechat.chat.controllers;

import java.util.List;
import org.privatechat.chat.DTOs.ChatChannelInitializationDTO;
import org.privatechat.chat.DTOs.ChatMessageDTO;
import org.privatechat.chat.DTOs.EstablishedChatChannelDTO;
import org.privatechat.chat.interfaces.IChatChannelController;
import org.privatechat.chat.services.ChatService;
import org.privatechat.shared.http.JSONResponseHelper;
import org.privatechat.user.exceptions.IsSameUserException;
import org.privatechat.user.exceptions.UserNotFoundException;
import org.privatechat.user.models.User;
import org.privatechat.user.services.UserService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ChatChannelController implements IChatChannelController {
  @Autowired
  private ChatService chatService;

  @Autowired
    private UserService userService;

    @MessageMapping("/private.chat.{channelId}")
    @SendTo("/topic/private.chat.{channelId}")
    public ChatMessageDTO chatMessage(@DestinationVariable String channelId, ChatMessageDTO message)
        throws BeansException, UserNotFoundException {
      chatService.submitMessage(message);

      return message;
    }

    @RequestMapping(value="/api/private-chat/channel", method=RequestMethod.PUT, produces="application/json", consumes="application/json")
    public ResponseEntity<String> establishChatChannel(@RequestBody ChatChannelInitializationDTO chatChannelInitialization) 
        throws IsSameUserException, UserNotFoundException { 
      String channelUuid = chatService.establishChatSession(chatChannelInitialization);
      User userOne = userService.getUser(chatChannelInitialization.getUserIdOne());
      User userTwo = userService.getUser(chatChannelInitialization.getUserIdTwo());

      EstablishedChatChannelDTO establishedChatChannel = new EstablishedChatChannelDTO(
        channelUuid,
        userOne.getFullName(),
        userTwo.getFullName()
      );
    
      return JSONResponseHelper.createResponse(establishedChatChannel, HttpStatus.OK);
    }
    
    @RequestMapping(value="/api/private-chat/channel/{channelUuid}", method=RequestMethod.GET, produces="application/json")
    public ResponseEntity<String> getExistingChatMessages(@PathVariable("channelUuid") String channelUuid) {
      List<ChatMessageDTO> messages = chatService.getExistingChatMessages(channelUuid);

      return JSONResponseHelper.createResponse(messages, HttpStatus.OK);
    }
}