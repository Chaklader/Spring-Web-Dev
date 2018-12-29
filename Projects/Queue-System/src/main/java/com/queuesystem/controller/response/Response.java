package com.queuesystem.controller.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.queuesystem.percistance.model.Queue;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;


@Data
public class Response implements Serializable {

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String message;

	private ResponseStatus status;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String error;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String response;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<ResponseQueue> queues;

	private Response(String message) {
		this.message = message;
	}

	private Response() {
	}

	public static Response getSuccessResponse(String message) {
		return getSuccessMessageResponse(message);
	}

	public static Response getSuccessResponse(List<Queue> queues) {
		Response response = new Response();
		response.setStatus(ResponseStatus.SUCCESS);
		response.setQueues(mapQueue(queues));
		return response;
	}

	public static Response getFailResponse(String message) {
		return getFailMessageResponse(message);
	}

	private static List<ResponseQueue> mapQueue(List<Queue> queues) {
		return queues.parallelStream().map(queue -> new ResponseQueue(queue.getName(), queue.getStatus())).collect(Collectors.toList());
	}

	private static Response getSuccessMessageResponse(String message) {
		Response response = new Response("request finished successfully");
		response.setResponse(message);
		response.setStatus(ResponseStatus.SUCCESS);
		return response;
	}

	private static Response getFailMessageResponse(String message) {
		Response response = new Response("request was failed");
		response.setError(message);
		response.setStatus(ResponseStatus.FAIL);
		return response;
	}

	private enum ResponseStatus {
		SUCCESS,
		FAIL
	}
}


