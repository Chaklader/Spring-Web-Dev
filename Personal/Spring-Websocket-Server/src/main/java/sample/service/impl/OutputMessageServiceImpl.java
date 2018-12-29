package sample.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.entity.OutputMessage;
import sample.repository.OutputMessageRepository;
import sample.service.def.OutputMessageService;

import java.util.List;

/**
 * Created by Chaklader on Nov, 2017
 */
@Service
public class OutputMessageServiceImpl implements OutputMessageService {

    @Autowired
    private OutputMessageRepository omRepository;

    @Override
    public List<OutputMessage> findAll() {
        return (List<OutputMessage>) omRepository.findAll();
    }

    @Override
    public void save(OutputMessage outputMessage) {
        omRepository.save(outputMessage);
    }
}
