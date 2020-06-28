package com.qbthon.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qbthon.model.EventDetails;
import com.qbthon.service.EventService;

@CrossOrigin
@RestController
@RequestMapping("/qbthonInfo")
public class EventController {
	
	@Autowired
	private EventService eventService;
	
	@GetMapping("/getDistinctSkills")
	public ResponseEntity<Set<String>> getDistinctSkills() {
		return ResponseEntity.status(HttpStatus.OK).body(eventService.getSkillsList());
	}
	
	
	@GetMapping("/getDistinctAssocIds")
	public ResponseEntity<List<String>> getDistinctAssocIds(@RequestParam("skills") String[] eventSkills) {
		return ResponseEntity.status(HttpStatus.OK).body(eventService.getAssocIdList(eventSkills));
	}
	
	@GetMapping("/getDistinctSmes")
	public ResponseEntity<List<String>> getDistinctSmes(@RequestParam("skills") String[] eventSkills) {
		return ResponseEntity.status(HttpStatus.OK).body(eventService.getSmeList(eventSkills));
	}
	
	@PostMapping("/createEventDetails")
	public EventDetails createEvent(@RequestBody EventDetails eventDet) {
		System.out.println("PostData =>"+eventDet);
		return eventService.createEvent(eventDet);
	}
	

}
