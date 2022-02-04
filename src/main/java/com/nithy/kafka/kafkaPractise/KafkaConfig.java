package com.nithy.kafka.kafkaPractise;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.nithy.kafka.kafkaPractise.Model.User;

@Configuration
@EnableAutoConfiguration
public class KafkaConfig extends KafkaPractiseApplication {

	@Bean
	public ProducerFactory<String, User> producerFactoryBeanForUser()
	{
		Map<String , Object > configs = new HashMap();
		configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.43.39:9092");
		configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);


		return new DefaultKafkaProducerFactory<>(configs);
	}

	@Bean("kafkaTemplateForUser")
	public KafkaTemplate<String, User> KafkaUserTemplate()
	{

		return new KafkaTemplate<>(producerFactoryBeanForUser());
	}

	@Bean
	public ProducerFactory<String, String> producerFactoryBean()
	{
		Map<String , Object > configs = new HashMap();
		configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.43.39:9092");
		configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);


		return new DefaultKafkaProducerFactory<>(configs);
	}

	@Bean("kafkaTemplateForString")
	public KafkaTemplate<String, String> KafkaTemplate()
	{

		return new KafkaTemplate<>(producerFactoryBean());
	}

}
