package com.queuesystem.percistance.model;

import java.text.MessageFormat;

/**
 * Created by Tengiz on 5/9/2017.
 */
public enum QueueActionType {
	CREATED("Created new Queue"),

	UPDATED("Updated Queue name from {0} to {1}"),

	STARTED("queue started"),

	ACTIVATED("Activated  Queue"),

	PAUSED("Paused Queue"),

	STOPPED("Stopped Queue"),

	DELETED("Deleted Queue");

	private String description;

	QueueActionType(String description) {
		this.description = description;
	}

	public String getText(Object... params) {
		return MessageFormat.format(description, params);
	}
}
