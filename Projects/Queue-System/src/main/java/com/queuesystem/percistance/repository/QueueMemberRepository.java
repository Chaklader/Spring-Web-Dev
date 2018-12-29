package com.queuesystem.percistance.repository;

import com.queuesystem.percistance.model.Queue;
import com.queuesystem.percistance.model.QueueMember;
import com.queuesystem.percistance.model.QueueMemberStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface QueueMemberRepository extends JpaRepository<QueueMember, Long> {

	int countQueueMemberByStatusAndQueue(QueueMemberStatus status, Queue queue);

	QueueMember getFirstByStatusAndQueueOrderByIdAsc(QueueMemberStatus status, Queue queue);

	QueueMember findByQueueNumberAndQueue(long queueNumber, Queue queue);

	@Query(value = "SELECT q.id FROM" +
			"  (SELECT id FROM queue WHERE queue.status =  :queueStatus) q" +
			"  LEFT JOIN" +
			"  (SELECT queue_id  FROM queue_member WHERE queue_member.status = :memberStatus) AS qm" +
			"  ON q.id = qm.queue_id" +
			"  GROUP BY q.id " +
			"  ORDER BY count(qm.queue_id) ASC " +
			"LIMIT 1", nativeQuery = true)
	Long getQueueIdWithLowestActiveMembersQuantity(
			@Param(value = "queueStatus") String queueStatus,
			@Param(value = "memberStatus") String memberStatus
	);

	int countByQueueAndStatusAndQueueNumberLessThan(Queue queue, QueueMemberStatus status, long queueNumber);
}
