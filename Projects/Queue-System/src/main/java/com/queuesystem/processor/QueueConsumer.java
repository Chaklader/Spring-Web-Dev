package com.queuesystem.processor;

import com.queuesystem.percistance.model.Queue;
import com.queuesystem.percistance.model.QueueMember;
import com.queuesystem.percistance.model.QueueMemberStatus;
import com.queuesystem.percistance.model.QueueStatus;
import com.queuesystem.percistance.repository.QueueMemberRepository;
import com.queuesystem.percistance.repository.QueueRepository;
import com.queuesystem.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class QueueConsumer implements Runnable {

	private static final Logger log = LoggerFactory.getLogger(QueueConsumer.class);

	private QueueMemberRepository queueMemberRepository;

	private QueueRepository queueRepository;

	private final Queue queue;

	QueueConsumer(Queue queue, QueueMemberRepository queueMemberRepository, QueueRepository queueRepository) {
		this.queue = queue;
		this.queueMemberRepository = queueMemberRepository;
		this.queueRepository = queueRepository;
	}

	@Override
	public void run() {
		try {
			while (true) {
				Thread.sleep(Utils.QUEUE_INTERVAL);

				if (queue.getStatus() == QueueStatus.STOPPED || queue.getStatus() == QueueStatus.DELETED) {
					log.info("Queue " + queue.getName() + " is  DELETED");
					return;
				}

				QueueMember member = queueMemberRepository.getFirstByStatusAndQueueOrderByIdAsc(QueueMemberStatus.IN_QUEUE, queue);
				if (queue.getStatus() == QueueStatus.ACTIVE && member != null) {
					consume(member);
					log.info("Consumed: [" + member.getName() + "],  Queue Number: [" + member.getQueueNumber() + "]  BY QUEUE: [" + queue.getName() + "]  ProductCode: [" + member.getProductCode() + "] ");
				} else {
					System.out.println(queue.getStatus());
					if (queue.getStatus() != QueueStatus.ACTIVE) {
						log.info("Queue: [ " + queue.getName() + " ] is in Paused Status");
					} else {
						log.info("Queue: [ " + queue.getName() + " ] has no people in line and waits");
					}
					queue.pause();
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	private void consume(QueueMember member) {
		String productCode = queue.getName() + "-" + queue.getNextConsumedIndex();
		member.setStatus(QueueMemberStatus.CONSUMED);
		member.setQueueLeaveTime(new Date());
		member.setProductCode(productCode);
		queueMemberRepository.save(member);
		queueRepository.save(queue);
	}

}