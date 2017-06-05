package com.cqrs.cqrsActiveMQdemo.command.event;

public class SampleDomainObjectCreatedEvent {
	
	String id;
	String name;
	
	public SampleDomainObjectCreatedEvent(String id, String name) {
		this.id = id;
		this.name = name;
	}
	public SampleDomainObjectCreatedEvent() {

	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	
}
