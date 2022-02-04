package com.nithy.kafka.kafkaPractise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class KafkaPractiseApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaPractiseApplication.class, args);
	}

}
