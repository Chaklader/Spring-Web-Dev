package com.queuesystem.percistance.repository;

import com.queuesystem.percistance.model.QueueActionLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueueActionLogRepository extends JpaRepository<QueueActionLog, Long> {
}
