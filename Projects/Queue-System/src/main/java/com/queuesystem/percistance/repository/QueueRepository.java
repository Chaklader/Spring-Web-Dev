package com.queuesystem.percistance.repository;

import com.queuesystem.percistance.model.Queue;
import com.queuesystem.percistance.model.QueueStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QueueRepository extends JpaRepository<Queue, Long> {

	Queue findByNameAndStatusNot(String name, QueueStatus queueStatus);

	List<Queue> findAllByStatus(QueueStatus queueStatus);

	List<Queue> findAllByStatusNot(QueueStatus queueStatus);


	int countByNameAndStatusNot(String name, QueueStatus queueStatus);

}
