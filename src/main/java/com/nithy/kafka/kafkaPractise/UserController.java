package com.nithy.kafka.kafkaPractise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nithy.kafka.kafkaPractise.Model.User;

@RestController
@RequestMapping("/kafka")
public class UserController  {

	@Autowired
	@Qualifier("kafkaTemplateForString")
	KafkaTemplate<String, String> template;

	@Autowired
	@Qualifier("kafkaTemplateForUser")
	KafkaTemplate<String, User> KafkaUserTemplate;

	final String topic = "quickstart-events";
	@GetMapping("/postMessage/{message}")
	public String postMessage(@PathVariable String message)
	{
		template.send(topic, message);

		return "message posted successfully";
	} 


	@PostMapping("/postUserDetails")
	public String postUserMessage(@RequestBody User user)
	{
		KafkaUserTemplate.send(topic, user);

		return "message posted successfully";
	}



}
