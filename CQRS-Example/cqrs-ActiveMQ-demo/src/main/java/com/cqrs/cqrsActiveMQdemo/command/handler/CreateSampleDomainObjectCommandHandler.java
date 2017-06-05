package com.cqrs.cqrsActiveMQdemo.command.handler;

import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cqrs.cqrsActiveMQdemo.command.CreateSampleDomainObjectCommand;
import com.cqrs.cqrsActiveMQdemo.command.domain.SampleDomainObject;

@Component
public class CreateSampleDomainObjectCommandHandler {
	
	private final Repository<SampleDomainObject> aggregates;

	@Autowired
	public CreateSampleDomainObjectCommandHandler(Repository<SampleDomainObject> aggregates) {
		this.aggregates = aggregates;
	}
	
	@CommandHandler
	public void handleReferenceCommand(CreateSampleDomainObjectCommand command){
		System.out.println("handling command "+command.getId());
		SampleDomainObject aggregate = new SampleDomainObject(command.getId(), command.getName());
		aggregates.add(aggregate);
	}
	
}
