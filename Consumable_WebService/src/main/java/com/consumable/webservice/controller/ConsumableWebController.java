package com.consumable.webservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consumable.webservice.entity.Dogs;
import com.consumable.webservice.service.ConsumableWebService;

@RestController
@RequestMapping(path = "consume")
public class ConsumableWebController {
	
	@Autowired
	private ConsumableWebService consumableWebService;
	
	@GetMapping("/getAllDogsObject")
	public List<Dogs> getAllDogsObject() {
		return consumableWebService.getAllDogsObject();
	}
	
	@GetMapping("/getAllDogsEntity")
	public List<Dogs> getAllDogsEntity() {
		return consumableWebService.getAllDogsEntity();
	}
	
	@GetMapping("/getAllDogsExchange")
	public List<Dogs> getAllDogsExchange() {
		return consumableWebService.getAllDogsExchange();
	}
	
	@GetMapping("/getDogsByIdObject/{dogId}")
	public Dogs getDogsByIdObject(@PathVariable Long dogId) {
		return consumableWebService.getDogsByIdObject(dogId);		
	}
	
	@GetMapping("/getDogsByIdEntity/{dogId}")
	public ResponseEntity<Dogs> getDogsByIdEntity(@PathVariable Long dogId) {
		return consumableWebService.getDogsByIdEntity(dogId);
	}
	
	@GetMapping("/getDogsByIdExchange/{dogId}")
	public ResponseEntity<Dogs> getDogsByIdExchange(@PathVariable Long dogId) {
		return consumableWebService.getDogsByIdExchange(dogId);
	}
	
	@PostMapping("/postDogsObject")
	public Dogs postDogsObject(@RequestBody Dogs dogs) {
		return consumableWebService.postDogsObject(dogs);
	}
	
	@PostMapping("/postDogsEntity")
	public ResponseEntity<Dogs> postDogsEntity(@RequestBody Dogs dogs) {
		return consumableWebService.postDogsEntity(dogs);
	}
	
	@PostMapping("/postDogsExchange")
	public ResponseEntity<Dogs> postDogsExchange(@RequestBody Dogs dogs) {
		return consumableWebService.postDogsExchange(dogs);
	}
	
	@PutMapping("/putDogs")
	public List<Dogs> putDogs(@RequestBody Dogs dogs) {
		return consumableWebService.putDogs(dogs);
	}
	
	@PutMapping("/putDogsExchange")
	public ResponseEntity<Dogs> putDogsExchange(@RequestBody Dogs dogs) {
		return consumableWebService.putDogsExchange(dogs);
	}
	
	@DeleteMapping("/deleteDogById/{dogId}")
	public List<Dogs> deleteDogById(@PathVariable Long dogId){
		return consumableWebService.deleteDogById(dogId);
	}
	
	@DeleteMapping("/deleteDogByIdExchange/{dogId}")
	public List<Dogs> deleteDogByIdExchange(@PathVariable Long dogId){
		return consumableWebService.deleteDogByIdExchange(dogId);
	}

}
