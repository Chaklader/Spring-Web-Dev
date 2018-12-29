package com.queuesystem.percistance.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class QueueMember {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;

	private String productCode;

	private long queueNumber;

	@Enumerated(EnumType.STRING)
	private QueueMemberStatus status;

	@ManyToOne
	private Queue queue;

	@Temporal(TemporalType.TIMESTAMP)
	private Date queueUpTime;

	@Temporal(TemporalType.TIMESTAMP)
	private Date queueLeaveTime;

	public QueueMember(Queue queue) {
		this.queue = queue;
	}

	public QueueMember() {
	}
}
