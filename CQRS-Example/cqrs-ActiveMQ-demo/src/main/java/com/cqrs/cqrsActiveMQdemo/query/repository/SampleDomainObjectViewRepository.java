package com.cqrs.cqrsActiveMQdemo.query.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.cqrs.cqrsActiveMQdemo.query.view.SampleDomainObjectView;

public interface SampleDomainObjectViewRepository extends PagingAndSortingRepository<SampleDomainObjectView, String>{
	
	List<SampleDomainObjectView> findByName(String name);
	
}
