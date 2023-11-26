package com.project.dogs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.dogs.entity.Dogs;
import com.project.dogs.service.DogsService;

@RestController
@RequestMapping("/dogs")
public class DogsController {
	
	@Autowired
	private DogsService dogsService;
	
	@PostMapping("/saveDogs")
	public Dogs saveDogs(@RequestBody Dogs dogs) {
		return dogsService.saveDogs(dogs);
	}
	
	@PutMapping("/updateDogs")
	public Dogs updateDogs(@RequestBody Dogs dogs) {
		return dogsService.saveDogs(dogs);
	}

	@GetMapping("/getDogById/{dogId}")
	public Dogs getDogById(@PathVariable Long dogId) {
		return dogsService.getDogById(dogId);
	}
	
	@GetMapping("/getAllDogs")
	public List<Dogs> getAllDogs() {
		return dogsService.getAllDogs();
	}

	@DeleteMapping("/removeDog/{dogId}")
	public List<Dogs> removeDog(@PathVariable Long dogId) {
		return dogsService.removeDog(dogId);
	}
	

}
