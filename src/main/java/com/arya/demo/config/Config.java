package com.arya.demo.config;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

	@Bean
	public Queue getQueue() {
		return new ActiveMQQueue("in.memory.queue");
	}

}
