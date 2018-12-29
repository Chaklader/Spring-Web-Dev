package org.privatechat.user.controllers;

import org.privatechat.user.interfaces.INotificationController;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

@RestController
public class NotificationController implements INotificationController {

  @SendTo("/topic/user.notification.{userId}")
  public String notifications(@DestinationVariable long userId, String message) {
    return message;
  }
}