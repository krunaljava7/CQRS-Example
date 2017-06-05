package com.cqrs.cqrsActiveMQdemo.command.domain;

import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;
import org.axonframework.eventsourcing.annotation.EventSourcingHandler;

import com.cqrs.cqrsActiveMQdemo.command.event.SampleDomainObjectCreatedEvent;

public class SampleDomainObject extends AbstractAnnotatedAggregateRoot<String>{

	@AggregateIdentifier
	String id;

	public SampleDomainObject() {}
	
	public SampleDomainObject(String id,String name){
		apply(new SampleDomainObjectCreatedEvent(id,name));
	}
	
	@EventSourcingHandler
	public void on(SampleDomainObjectCreatedEvent event){
		this.id = event.getId();
	}
}
