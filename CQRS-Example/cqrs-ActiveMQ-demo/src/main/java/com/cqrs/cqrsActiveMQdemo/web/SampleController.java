package com.cqrs.cqrsActiveMQdemo.web;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cqrs.cqrsActiveMQdemo.command.CreateSampleDomainObjectCommand;
import com.cqrs.cqrsActiveMQdemo.query.repository.SampleDomainObjectViewRepository;
import com.cqrs.cqrsActiveMQdemo.query.view.SampleDomainObjectView;

@RestController
public class SampleController {
	
	private final CommandGateway commandGateway;
	private final SampleDomainObjectViewRepository repository;
	
	@Autowired
	public SampleController(CommandGateway commandGateway,
			SampleDomainObjectViewRepository sampleDomainObjectViewRepository) {
		this.commandGateway = commandGateway;
		this.repository = sampleDomainObjectViewRepository;
	}
	
	@GetMapping()
	public ResponseEntity<List<SampleDomainObjectView>> searchAll(){
		final List<SampleDomainObjectView> views = (List<SampleDomainObjectView>) repository.findAll();
		
		if(views == null || views.isEmpty()){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
		return new ResponseEntity<>(views,HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity produce(@RequestBody Map<String,String> request){
		System.out.println("producer sending Command");
		commandGateway.sendAndWait(new CreateSampleDomainObjectCommand(UUID.randomUUID().toString(), request.get("name")));
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
}
