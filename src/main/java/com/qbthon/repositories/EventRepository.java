package com.qbthon.repositories;
import java.util.List;


import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.qbthon.model.EventDetails;

@EnableScan
public interface EventRepository extends CrudRepository<EventDetails, String> {

	
	public List<EventDetails> findAll();
}
