package com.queuesystem.percistance.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Queue {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private long nextIndex = 1;

	private long nextConsumedIndex = 1;

	private String name;

	@Enumerated(EnumType.STRING)
	private QueueStatus status;

	@Temporal(TemporalType.TIMESTAMP)
	private Date startTime;

	@Temporal(TemporalType.TIMESTAMP)
	private Date endTime;

	@PrePersist
	private void postPersist() {
		startTime = new Date();
	}

	public long getNextIndex() {
		return nextIndex++;
	}

	public long getNextConsumedIndex() {
		return nextConsumedIndex++;
	}

	public synchronized void awake() {
		notify();
	}

	public synchronized void pause() throws InterruptedException {
		wait();
	}
}
