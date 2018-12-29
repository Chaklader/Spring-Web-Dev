package sample.service.def;

import sample.entity.Message;
import sample.entity.OutputMessage;

import java.util.List;

/**
 * Created by Chaklader on Nov, 2017
 */
public interface MessageService {

    List<Message> findAll();

    void save(Message message);
}
