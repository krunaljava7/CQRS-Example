package com.cqrs.cqrsActiveMQdemo.command;

public class CreateSampleDomainObjectCommand {
	
	private String id;
	
	private String name;

	public CreateSampleDomainObjectCommand(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public CreateSampleDomainObjectCommand() {
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	
}
