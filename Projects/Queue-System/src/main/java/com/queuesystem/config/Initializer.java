package com.queuesystem.config;

import com.queuesystem.percistance.model.Queue;
import com.queuesystem.percistance.model.QueueStatus;
import com.queuesystem.percistance.repository.QueueMemberRepository;
import com.queuesystem.percistance.repository.QueueRepository;
import com.queuesystem.processor.QueueProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

@Scope("singleton")
@Component
public class Initializer {

	private static final Logger log = LoggerFactory.getLogger(Initializer.class);

	private QueueRepository queueRepository;

	private QueueMemberRepository queueMemberRepository;

	private final Map<Long, QueueProcessor> queueMap;

	@Autowired
	public Initializer(QueueRepository queueRepository, QueueMemberRepository queueMemberRepository, Map<Long, QueueProcessor> queueMap) {
		this.queueRepository = queueRepository;
		this.queueMemberRepository = queueMemberRepository;
		this.queueMap = queueMap;
	}

	@PostConstruct
	public void init() {
		log.info("-------------- Start of initializing -----------------------");
		List<Queue> queueList = queueRepository.findAllByStatusNot(QueueStatus.DELETED);

		queueList.forEach(queue -> {
			QueueProcessor queueProcessor = new QueueProcessor(queue, queueMemberRepository, queueRepository);
			queueMap.put(queue.getId(), queueProcessor);
			if (queue.getStatus() != QueueStatus.STOPPED) {
				queueProcessor.start();
			}
			log.info(queue.getName() + "  was initialized  [" + queue + " ]");
		});
	}
}
