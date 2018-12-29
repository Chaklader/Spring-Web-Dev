package sample.service.def;

import sample.entity.OutputMessage;

import java.util.List;

/**
 * Created by Chaklader on Nov, 2017
 */
public interface OutputMessageService {

    List<OutputMessage> findAll();

    void save(OutputMessage  outputMessage);
}
