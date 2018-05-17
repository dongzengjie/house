package com.dzj.house.rabbitMQ;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
	
	public static final String TOPIC_EXCHANGE="topic_exchange";
	public static final String TOPIC_QUERY="topic_query";
	public static final String KEY="elasticSearch";
	@Bean
	public Queue topic_query() {
		return new Queue(TOPIC_QUERY, true);
	}
	@Bean
	public TopicExchange topicExchange() {
		return new TopicExchange(TOPIC_EXCHANGE);
	}
	@Bean
	public Binding binding() {
		return BindingBuilder.bind(topic_query()).to(topicExchange()).with(KEY);
	}
}
