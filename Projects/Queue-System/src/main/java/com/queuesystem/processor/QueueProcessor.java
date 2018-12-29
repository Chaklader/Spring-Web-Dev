package com.queuesystem.processor;

import com.queuesystem.exception.AppException;
import com.queuesystem.exception.ErrorCode;
import com.queuesystem.percistance.model.Queue;
import com.queuesystem.percistance.model.QueueMember;
import com.queuesystem.percistance.model.QueueMemberStatus;
import com.queuesystem.percistance.model.QueueStatus;
import com.queuesystem.percistance.repository.QueueMemberRepository;
import com.queuesystem.percistance.repository.QueueRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class QueueProcessor {

	private QueueMemberRepository queueMemberRepository;

	private QueueRepository queueRepository;

	private static final Logger log = LoggerFactory.getLogger(QueueProcessor.class);

	private final Queue queue;

	public QueueProcessor(Queue queue, QueueMemberRepository queueMemberRepository, QueueRepository queueRepository) {
		this.queue = queue;
		this.queueMemberRepository = queueMemberRepository;
		this.queueRepository = queueRepository;
	}

	public void start() {
		QueueConsumer consumer = new QueueConsumer(queue, queueMemberRepository, queueRepository);
		Thread thread = new Thread(consumer);
		thread.start();
	}

	public QueueMember addMember(String queueMemberName) throws AppException {
		checkOnQueueStatus();
		QueueMember queueMember = createQueueMember(queueMemberName);

		if (queueMemberRepository.countQueueMemberByStatusAndQueue(QueueMemberStatus.IN_QUEUE, queue) == 0) {
			queueMemberRepository.save(queueMember);
			log.info("Awaking queue " + queue.getName());
			queue.awake();
		} else {
			queueMember = queueMemberRepository.save(queueMember);
		}
		log.info("Added new Queue Member -  name: [ " + queueMember.getName() + " ];" + "  Queue Number " + queueMember.getQueueNumber() + " INTO QUEUE:  [ " + queue.getName() + " ]");
		return queueMember;
	}

	public QueueMember removeMember(long queueNumber) throws AppException {
		checkOnQueueStatus();
		QueueMember member = queueMemberRepository.findByQueueNumberAndQueue(queueNumber, queue);
		if (member == null) {
			throw new AppException(ErrorCode.NO_MEMBER_IN_QUEUE, queueNumber, queue.getName());
		}
		if (member.getStatus() != QueueMemberStatus.IN_QUEUE) {
			throw new AppException(ErrorCode.QUEUE_MEMBER_IS_NOT_IN_QUEUE, member.getName(), queue.getName());
		}
		member.setStatus(QueueMemberStatus.LEFT_QUEUE_MANUALLY);
		member.setQueueLeaveTime(new Date());
		return queueMemberRepository.save(member);
	}

	public String getMemberInfo(long queueNumber) throws AppException {
		checkOnQueueStatus();
		QueueMember requestedMember = queueMemberRepository.findByQueueNumberAndQueue(queueNumber, queue);
		if (requestedMember == null) {
			throw new AppException(ErrorCode.NO_MEMBER_IN_QUEUE, queueNumber, queue.getName());
		}
		if (requestedMember.getProductCode() != null) {
			return "Your product Code Is: " + requestedMember.getProductCode();
		}
		if (requestedMember.getStatus() != QueueMemberStatus.IN_QUEUE) {
			throw new AppException(ErrorCode.QUEUE_MEMBER_LEFT_QUEUE, requestedMember.getName(), queue.getName());
		}
		int peopleBeforeMe = queueMemberRepository.countByQueueAndStatusAndQueueNumberLessThan(queue, QueueMemberStatus.IN_QUEUE, requestedMember.getQueueNumber());
		if (peopleBeforeMe == 0) {
			return "you are being consumed right now";
		}
		return "before you in Queue:" + queue.getName() + " are Standing: " + peopleBeforeMe + " people";

	}

	private QueueMember createQueueMember(String queueMemberName) {
		QueueMember queueMember = new QueueMember();
		queueMember.setName(queueMemberName);
		queueMember.setQueue(queue);
		queueMember.setStatus(QueueMemberStatus.IN_QUEUE);
		queueMember.setQueueUpTime(new Date());
		queueMember.setQueueNumber(queue.getNextIndex());
		queueRepository.save(queue);
		return queueMember;
	}

	public void changeStatus(QueueStatus queueStatus) {
		if (queue.getStatus() == QueueStatus.STOPPED) {
			queue.setStatus(queueStatus);
			start();
		}
		queue.setStatus(queueStatus);
		queue.awake();
	}

	public void changeName(String newName) {
		queue.setName(newName);
	}

	private void checkOnQueueStatus() throws AppException {
		if (queue.getStatus() != QueueStatus.ACTIVE) {
			throw new AppException(ErrorCode.QUEUE_IS_NOT_ACTIVE, queue.getName());
		}
	}
}
