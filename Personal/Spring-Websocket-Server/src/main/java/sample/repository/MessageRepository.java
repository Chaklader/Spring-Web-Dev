package sample.repository;

import org.springframework.data.repository.CrudRepository;
import sample.entity.Message;

/**
 * Created by Chaklader on Nov, 2017
 */
public interface MessageRepository extends CrudRepository<Message, Long> {
}
