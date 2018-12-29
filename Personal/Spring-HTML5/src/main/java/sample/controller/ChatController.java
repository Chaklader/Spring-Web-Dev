package sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import sample.entity.Message;
import sample.entity.OutputMessage;
import sample.service.def.MessageService;
import sample.service.def.OutputMessageService;

/**
 * Created by Chaklader on Nov, 2017
 */
@Controller
public class ChatController {

//    @Autowired
//    private OutputMessageService outputMessageService;
//
//    @Autowired
//    private MessageService messageService;
//
//    @MessageMapping("/chat/{topic}")
//    @SendTo("/topic/messages")
//    public OutputMessage send(@DestinationVariable("topic") String topic,
//                              Message message) throws Exception {
//
//        OutputMessage outputMessage = new OutputMessage(message.getFrom(), message.getText(), topic);
//
//        System.out.println("Inout Message" + message.toString());
//        System.out.println("Output Message" + outputMessage.toString());
//
//        outputMessageService.save(outputMessage);
//        messageService.save(message);
//
//        return outputMessage;
//    }
}
