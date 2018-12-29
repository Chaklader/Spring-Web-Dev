package com.queuesystem.exception;

public enum ErrorCode {

	QUEUE_IS_NOT_ACTIVE("Queue: {0} Is Not in Active Status"),

	NO_ACTIVE_QUEUES("at this time there is not active queue"),

	QUEUE_DOES_NOT_EXISTS("Queue does not exists with name: {0}"),

	QUEUE_IS_ALREADY_IN_STATUS("Queue: {0} is Already in {1} status"),

	QUEUE_NAME_IS_USED("Queue with name: {0} already exists"),

	SAME_QUEUE_NAME("new  and old queue names are same"),

	NO_MEMBER_IN_QUEUE("there is not member with queueNumber: {0} in queue: {1} "),

	QUEUE_MEMBER_IS_NOT_IN_QUEUE("{0} is not in queue {1}"),

	QUEUE_MEMBER_LEFT_QUEUE("{0} has left queue: {1} until consuming");

	private String description;

	ErrorCode(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}