package com.cqrs.cqrsActiveMQdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.cqrs.cqrsActiveMQdemo.configuration.AxonConfig;


@SpringBootApplication
public class CqrsActiveMqDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CqrsActiveMqDemoApplication.class, args);
	}
}
