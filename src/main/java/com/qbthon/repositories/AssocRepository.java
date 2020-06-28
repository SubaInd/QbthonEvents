package com.qbthon.repositories;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.qbthon.model.AssociateDetails;

@EnableScan
public interface AssocRepository extends CrudRepository<AssociateDetails, String> {
	
	public List<AssociateDetails> findAll();
	

}
