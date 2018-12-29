package com.queuesystem.config;

import com.queuesystem.processor.QueueProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Configuration
public class AppConfig {

	private Map<Long, QueueProcessor> queueMap = new ConcurrentHashMap<>();

	@Bean
	public Map<Long, QueueProcessor> queueMap() {
		return queueMap;
	}
}
