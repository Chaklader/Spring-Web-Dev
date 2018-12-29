package com.queuesystem.controller.response;

import com.queuesystem.percistance.model.QueueStatus;
import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseQueue implements Serializable {
	private String name;
	private QueueStatus status;

	ResponseQueue(String name, QueueStatus status) {
		this.name = name;
		this.status = status;
	}
}