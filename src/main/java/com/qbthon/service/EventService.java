package com.qbthon.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.qbthon.model.AssociateDetails;
import com.qbthon.model.EventDetails;
import com.qbthon.repositories.AssocRepository;
import com.qbthon.repositories.EventRepository;

@Service
public class EventService {
	
	@Autowired 
	private DynamoDBMapper dynamoDBMapper;
	
	@Autowired
	EventRepository eventRepo;
	
	@Autowired
	AssocRepository assocRepo;
	
	public Set<String> getSkillsList() {
		
		Set<String> eventSkillsSet = new HashSet<String>();
		List<AssociateDetails> assocDetails = new ArrayList<AssociateDetails>();
		assocDetails.addAll(assocRepo.findAll());
		  
		assocDetails.forEach(assocDetail -> eventSkillsSet.addAll(assocDetail.getSkillList()));
		
		eventSkillsSet.forEach(skills -> System.out.println(skills));
		return eventSkillsSet;
	}

	public EventDetails createEvent(EventDetails eventDet) {
		return eventRepo.save(eventDet);
	}

	public List<String> getAssocIdList(String[] eventSkills) {
		String role = "USER";
		List<AssociateDetails> assocDetails = new ArrayList<AssociateDetails>();
		String[] skills = {};
		if(0 < eventSkills.length) {
			skills = new String[eventSkills.length];
			skills = eventSkills;	
		 }
		Map<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
		//eav.put(":userRole", new AttributeValue().withS(role));
		int i = 0;
        StringBuilder sb = new StringBuilder("");
        for (String skill : skills) {
        	System.out.println("Index value => "+i);
        	//if(i==0)
        		//sb.append(" AND (");
        	sb.append("contains (skillList, :skills"+i+")");
        	if(i != skills.length-1) {
        		sb.append(" or ");
        	}
        	/*if(i == skills.length-1) {
        		sb.append(")");
        	}*/
        	eav.put(":skills"+i++, new AttributeValue().withS(skill));
        }
        
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
	            .withFilterExpression(sb.toString()).withExpressionAttributeValues(eav);
        assocDetails = dynamoDBMapper.scan(AssociateDetails.class, scanExpression);
        
        List<String> assocIdList = new ArrayList<String>();
		  
        assocDetails.forEach(assocDetail -> assocIdList.add(assocDetail.getAssociateId()));
        assocIdList.forEach(assocId -> System.out.println(assocId));
        return assocIdList;
		
	}
	
	
	public List<String> getSmeList(String[] eventSkills) {
		String role = "SME";
		List<AssociateDetails> assocDetails = new ArrayList<AssociateDetails>();
		String[] skills = {};
		if(0 < eventSkills.length) {
			skills = new String[eventSkills.length];
			skills = eventSkills;	
		 }
		Map<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
		//eav.put(":userRole", new AttributeValue().withS(role));
		int i = 0;
        StringBuilder sb = new StringBuilder("");
        for (String skill : skills) {
        	System.out.println("Index value => "+i);
        	//if(i==0)
        		//sb.append(" AND (");
        	sb.append("contains (skillList, :skills"+i+")");
        	if(i != skills.length-1) {
        		sb.append(" or ");
        	}
        	/*if(i == skills.length-1) {
        		sb.append(")");
        	}*/
        	eav.put(":skills"+i++, new AttributeValue().withS(skill));
        }
        
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
	            .withFilterExpression(sb.toString()).withExpressionAttributeValues(eav);
        assocDetails = dynamoDBMapper.scan(AssociateDetails.class, scanExpression);
        
        List<String> assocIdList = new ArrayList<String>();
		  
        assocDetails.forEach(assocDetail -> assocIdList.add(assocDetail.getAssociateId()));
        assocIdList.forEach(assocId -> System.out.println(assocId));
        return assocIdList;
		
	}

}
