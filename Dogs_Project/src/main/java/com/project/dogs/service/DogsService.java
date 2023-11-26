package com.project.dogs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dogs.entity.Dogs;
import com.project.dogs.repository.DogsRepository;

@Service
public class DogsService {
	
	@Autowired
	private DogsRepository dogsRepository;
	
	public Dogs saveDogs(Dogs dogs) {
		return dogsRepository.save(dogs);
	}

	public Dogs getDogById(Long dogId) {
		return dogsRepository.findById(dogId).get();
	}
	
	public List<Dogs> getAllDogs() {
		return dogsRepository.findAll();
	}

	public List<Dogs> removeDog(Long dogId) {
		dogsRepository.deleteById(dogId);
		return dogsRepository.findAll();
	}

}
