package com.example.springbootmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class SpringMicroserviceApplication {
	private static final Logger logger = LoggerFactory.getLogger(SpringMicroserviceApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(SpringMicroserviceApplication.class, args);
		logger.info("Message Logged at INFO Level");
		logger.error("Message Logged at ERROR Level");
		logger.warn("Message Logged at WARN Level");
		logger.debug("Message Logged at DEBUG Level");
	}
	
	@Autowired
	private Environment env;
}
