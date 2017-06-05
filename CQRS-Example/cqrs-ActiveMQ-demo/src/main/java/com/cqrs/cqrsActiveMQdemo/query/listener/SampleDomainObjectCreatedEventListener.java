package com.cqrs.cqrsActiveMQdemo.query.listener;

import org.axonframework.eventhandling.annotation.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cqrs.cqrsActiveMQdemo.command.event.SampleDomainObjectCreatedEvent;
import com.cqrs.cqrsActiveMQdemo.query.repository.SampleDomainObjectViewRepository;
import com.cqrs.cqrsActiveMQdemo.query.view.SampleDomainObjectView;

@Component
public class SampleDomainObjectCreatedEventListener {

	private final SampleDomainObjectViewRepository repository;

	@Autowired
	public SampleDomainObjectCreatedEventListener(SampleDomainObjectViewRepository repository) {
		this.repository = repository;
	}
	
	@EventHandler
	public void on(SampleDomainObjectCreatedEvent event){
		System.out.println("received event");
		repository.save(new SampleDomainObjectView(event.getId(),event.getName()));
	}
	
}
