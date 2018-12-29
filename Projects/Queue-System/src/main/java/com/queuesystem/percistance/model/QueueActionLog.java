package com.queuesystem.percistance.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class QueueActionLog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	private Queue queue;

	private String action;

	@Temporal(TemporalType.TIMESTAMP)
	private Date actionTime;

	@PrePersist
	private void postPersist() {
		actionTime = new Date();
	}

	public QueueActionLog(String action, Queue queue) {
		this.action = action;
		this.queue = queue;
	}
}
