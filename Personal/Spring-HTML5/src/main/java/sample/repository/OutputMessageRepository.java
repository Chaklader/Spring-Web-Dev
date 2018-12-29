package sample.repository;

import org.springframework.data.repository.CrudRepository;
import sample.entity.OutputMessage;

/**
 * Created by Chaklader on Nov, 2017
 */
public interface OutputMessageRepository extends CrudRepository<OutputMessage, Long> {
}
