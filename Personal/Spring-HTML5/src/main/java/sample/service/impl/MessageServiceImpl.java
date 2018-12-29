package sample.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.entity.Message;
import sample.repository.MessageRepository;
import sample.service.def.MessageService;

import java.util.List;

/**
 * Created by Chaklader on Nov, 2017
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public List<Message> findAll() {
        return (List<Message>) messageRepository.findAll();
    }

    @Override
    public void save(Message message) {
        messageRepository.save(message);
    }
}
