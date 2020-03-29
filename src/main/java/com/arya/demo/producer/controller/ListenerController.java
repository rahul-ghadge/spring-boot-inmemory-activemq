package com.arya.demo.producer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.arya.demo.model.SuperHero;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ListenerController {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ObjectMapper mapper;

	@JmsListener(destination = "in.memory.queue")
	public void getMessage(String message) {

		LOGGER.info("Inside ListenerController::getMessage() ");
		System.out.println("Received Message : " + message);
		LOGGER.info("Received Message : {}", message);

		SuperHero hero = null;
		try {
			hero = (SuperHero) mapper.readValue(message, SuperHero.class);
		} catch (JsonProcessingException e) {}

		if (null != hero) {
			System.out.println("Super Hero : " + hero);
			LOGGER.info("Super Hero : {}", hero);
		}
	}

}
