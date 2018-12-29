package com.queuesystem.service;

import com.queuesystem.exception.AppException;
import com.queuesystem.exception.ErrorCode;
import com.queuesystem.percistance.model.*;
import com.queuesystem.percistance.repository.QueueActionLogRepository;
import com.queuesystem.percistance.repository.QueueMemberRepository;
import com.queuesystem.percistance.repository.QueueRepository;
import com.queuesystem.processor.QueueProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class QueueManager {

	private static final Logger log = LoggerFactory.getLogger(QueueManager.class);

	private QueueRepository queueRepository;

	private QueueMemberRepository queueMemberRepository;

	private QueueActionLogRepository actionLogRepository;

	private Map<Long, QueueProcessor> queueMap;

	@Autowired
	public QueueManager(QueueRepository queueRepository, QueueMemberRepository queueMemberRepository, QueueActionLogRepository actionLogRepository, Map<Long, QueueProcessor> queueMap) {
		this.queueRepository = queueRepository;
		this.queueMemberRepository = queueMemberRepository;
		this.actionLogRepository = actionLogRepository;
		this.queueMap = queueMap;
	}

	public List<Queue> getAllQueue() throws AppException {
		List<Queue> queues = queueRepository.findAllByStatus(QueueStatus.ACTIVE);
		if (queues.isEmpty()) {
			throw new AppException(ErrorCode.NO_ACTIVE_QUEUES);
		}
		return queues;
	}

	public String addQueueAndStart(String name) throws AppException {
		addQueue(name);
		startQueue(name);
		return "Queue Added and Started Successfully";
	}

	public String addQueue(String name) throws AppException {
		checkIfExists(name);
		Queue queue = new Queue();
		queue.setStatus(QueueStatus.PAUSED);
		queue.setName(name);
		QueueProcessor queueProcessor = new QueueProcessor(queue, queueMemberRepository, queueRepository);
		queue = queueRepository.save(queue);
		queueMap.put(queue.getId(), queueProcessor);

		actionLogRepository.save(new QueueActionLog(QueueActionType.CREATED.getText(), queue));
		log.info("Added new Queue: [ " + queue.getName() + " ]");
		return "Queue Added Successfully";
	}

	public String updateQueue(String name, String newName) throws AppException {
		Queue queue = getQueueByName(name);
		checkQueueOnNull(name, queue);
		if (name.equals(newName)) {
			throw new AppException(ErrorCode.SAME_QUEUE_NAME);
		}
		checkIfExists(newName);
		queueMap.get(queue.getId()).changeName(newName);
		queue.setName(newName);
		queueRepository.save(queue);
		actionLogRepository.save(new QueueActionLog(QueueActionType.UPDATED.getText(name, newName), queue));
		log.info("Queue updated  changed name from: " + name + " to:" + newName);
		return "Queue updated Successfully";
	}

	public String startQueue(String name) throws AppException {
		Queue queue = getQueueByName(name);
		if (queue.getStatus() == QueueStatus.ACTIVE) {
			throw new AppException(ErrorCode.QUEUE_IS_ALREADY_IN_STATUS, name, QueueStatus.ACTIVE.toString());
		}
		queueMap.get(queue.getId()).start();
		queue.setStatus(QueueStatus.ACTIVE);
		queueRepository.save(queue);
		actionLogRepository.save(new QueueActionLog(QueueActionType.STARTED.getText(name), queue));
		log.info("Queue: [ " + queue.getName() + " ] Started");
		return "Queue started Successfully";
	}

	public String deleteQueue(String name) throws AppException {
		Queue queue = getQueueByName(name);
		checkQueueOnNull(name, queue);
		changeStatus(queue, QueueStatus.DELETED);
		queue.setEndTime(new Date());
		queueRepository.save(queue);
		queueMap.remove(queue.getId());
		actionLogRepository.save(new QueueActionLog(QueueActionType.DELETED.getText(), queue));
		log.info(queue.getName() + "  Deleted");
		return "Queue Deleted Successfully";
	}

	public String resumeQueue(String name) throws AppException {
		Queue queue = getQueueByName(name);
		checkQueueForStatusChange(name, queue, QueueStatus.ACTIVE);
		changeStatus(queue, QueueStatus.ACTIVE);
		queueRepository.save(queue);
		actionLogRepository.save(new QueueActionLog(QueueActionType.ACTIVATED.getText(), queue));
		log.info(queue.getName() + "  resumed");
		return "Queue resumed Successfully";
	}

	public String pauseQueue(String name) throws AppException {
		Queue queue = getQueueByName(name);
		checkQueueForStatusChange(name, queue, QueueStatus.PAUSED);
		changeStatus(queue, QueueStatus.PAUSED);
		queueRepository.save(queue);
		actionLogRepository.save(new QueueActionLog(QueueActionType.PAUSED.getText(), queue));
		log.info(queue.getName() + "  paused");
		return "Queue paused Successfully";
	}

	public String stopQueue(String name) throws AppException {
		Queue queue = getQueueByName(name);
		checkQueueForStatusChange(name, queue, QueueStatus.STOPPED);
		changeStatus(queue, QueueStatus.STOPPED);
		queueRepository.save(queue);
		actionLogRepository.save(new QueueActionLog(QueueActionType.STOPPED.getText(), queue));
		log.info(queue.getName() + "  cancelled");
		return "Queue Stopped Successfully";

	}

	public String addMember(String memberName, String queueName) throws AppException {
		Queue queue = getQueueByName(queueName);
		checkQueueOnNull(queueName, queue);
		QueueMember member = queueMap.get(queue.getId()).addMember(memberName);
		return memberName + " added in Queue: " + queueName + " successfully.  your queue number is: " +
				member.getQueueNumber() + ".   you can check people before you in queue  with queue number";

	}

	public String removeMember(long queueNumber, String queueName) throws AppException {
		Queue queue = getQueueByName(queueName);
		checkQueueOnNull(queueName, queue);
		QueueMember member = queueMap.get(queue.getId()).removeMember(queueNumber);
		return member.getName() + " removed from Queue: " + queueName + " successfully";
	}

	public String addMember(String memberName) throws AppException {
		Queue queue = queueRepository.getOne(queueMemberRepository.getQueueIdWithLowestActiveMembersQuantity(QueueStatus.ACTIVE.toString(), QueueMemberStatus.IN_QUEUE.toString()));
		QueueMember member = queueMap.get(queue.getId()).addMember(memberName);
		return memberName + " added in Queue: " + queue.getName() + " successfully.  your queue number is: " +
				member.getQueueNumber() + ".   you can check people before you in queue  with queue number";
	}


	public String getMyInfo(long queueNumber, String queueName) throws AppException {
		Queue queue = getQueueByName(queueName);
		checkQueueOnNull(queueName, queue);
		return queueMap.get(queue.getId()).getMemberInfo(queueNumber);
	}

	private void checkIfExists(String name) throws AppException {
		if (queueRepository.countByNameAndStatusNot(name, QueueStatus.DELETED) > 0) {
			throw new AppException(ErrorCode.QUEUE_NAME_IS_USED, name);
		}
	}

	private void changeStatus(Queue queue, QueueStatus queueStatus) throws AppException {
		QueueProcessor processor = queueMap.get(queue.getId());
		processor.changeStatus(queueStatus);
		queue.setStatus(queueStatus);
	}

	private void checkQueueForStatusChange(String name, Queue queue, QueueStatus queueStatus) throws AppException {
		if (queue == null) {
			throw new AppException(ErrorCode.QUEUE_DOES_NOT_EXISTS, name);
		} else if (queue.getStatus() == queueStatus) {
			throw new AppException(ErrorCode.QUEUE_IS_ALREADY_IN_STATUS, name, queueStatus.toString());
		}
	}

	private void checkQueueOnNull(String name, Queue queue) throws AppException {
		if (queue == null) {
			throw new AppException(ErrorCode.QUEUE_DOES_NOT_EXISTS, name);
		}
	}

	private Queue getQueueByName(String queueName) {
		return queueRepository.findByNameAndStatusNot(queueName, QueueStatus.DELETED);
	}
}
