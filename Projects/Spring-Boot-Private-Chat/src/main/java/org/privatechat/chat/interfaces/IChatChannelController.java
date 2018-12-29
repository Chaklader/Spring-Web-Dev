package org.privatechat.chat.interfaces;

import org.privatechat.chat.DTOs.ChatChannelInitializationDTO;
import org.privatechat.chat.DTOs.ChatMessageDTO;
import org.privatechat.user.exceptions.IsSameUserException;
import org.privatechat.user.exceptions.UserNotFoundException;
import org.springframework.beans.BeansException;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface IChatChannelController {
    ChatMessageDTO chatMessage(@DestinationVariable String channelId, ChatMessageDTO message)
        throws BeansException, UserNotFoundException;

    ResponseEntity<String> establishChatChannel(@RequestBody ChatChannelInitializationDTO chatChannelInitialization)
        throws IsSameUserException, UserNotFoundException; 

    ResponseEntity<String> getExistingChatMessages(@PathVariable("channelUuid") String channelUuid);
}
