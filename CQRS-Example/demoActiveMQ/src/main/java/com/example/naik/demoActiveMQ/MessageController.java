package com.example.naik.demoActiveMQ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MessageController {

	@Autowired
	Producer producer;
	
	
	@RequestMapping("/send")
	public void printMessage(){
		System.out.println("Sending an message.");
		producer.send("sample message ");
	}
}
