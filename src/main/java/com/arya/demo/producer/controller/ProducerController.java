package com.arya.demo.producer.controller;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.arya.demo.model.SuperHero;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@Scope("prototype")
public class ProducerController {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired	private Queue queue;

	@Autowired	private JmsTemplate jmsTemplate;
	
	@Autowired private ObjectMapper mapper;
	

	@GetMapping("/")
	public String ping() {
		LOGGER.info("Inside ProducerController::ping() ");
		return "pong";
	}

	@GetMapping("/message/{message}")
	public String sendTextMessage(@PathVariable String message) {
		
		LOGGER.info("Inside ProducerController::sendTextMessage() ");
		LOGGER.info("Sending Message :: {} ", message);
		
		jmsTemplate.convertAndSend(queue, message);
		
		LOGGER.info("Message sent successfully...!");
		
		return "Sent message : " + message;
	}
	
	
	
	@PostMapping("/superhero")
	public SuperHero sendObjectMessage(@RequestBody SuperHero superHero) {
		
		LOGGER.info("Inside ProducerController::sendObjectMessage() ");
		LOGGER.info("Sending Message :: {} ", superHero);
		
		try {
			String superHeroString = mapper.writeValueAsString(superHero);

			jmsTemplate.convertAndSend(queue, superHeroString);
		
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		
		
//		jmsTemplate.send(queue, new MessageCreator() {
//            @Override
//            public Message createMessage(Session session) throws JMSException {
//                return session.createObjectMessage(superHero);
//            }
//        });
//		
		
		LOGGER.info("Message sent successfully...!");
		
		return superHero;
	}

}
