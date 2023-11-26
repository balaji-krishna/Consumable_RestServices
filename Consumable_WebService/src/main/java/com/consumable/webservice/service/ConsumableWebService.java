package com.consumable.webservice.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.consumable.webservice.entity.Dogs;

@Service
public class ConsumableWebService {

	RestTemplate restTemplate = new RestTemplate();
	
	public List<Dogs> getAllDogsObject() {
		Dogs[] dogsList = restTemplate.getForObject("http://localhost:9090/dogs/getAllDogs", Dogs[].class);
		if(dogsList != null) {
			return Arrays.asList(dogsList);
		} else {
			return new ArrayList<Dogs>();
		}
	}
	
	public List<Dogs> getAllDogsEntity() {
		ResponseEntity<Dogs[]> responseEntity = restTemplate.getForEntity("http://localhost:9090/dogs/getAllDogs", Dogs[].class);
		Dogs[] dogsList = responseEntity.getBody();
		if(dogsList != null) {
			return Arrays.asList(dogsList);
		} else {
			return new ArrayList<Dogs>();
		}
	}
	
	public List<Dogs> getAllDogsExchange() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity <String> httpEntity = new HttpEntity<String>(headers);
		ResponseEntity<Dogs[]> responseEntity = restTemplate.exchange("http://localhost:9090/dogs/getAllDogs", HttpMethod.GET, httpEntity, Dogs[].class);
		Dogs[] dogsList = responseEntity.getBody();
		if(dogsList != null) {
			return Arrays.asList(dogsList);
		} else {
			return new ArrayList<Dogs>();
		}
	}
	
	public Dogs getDogsByIdObject(Long dogId) {
		return restTemplate.getForObject("http://localhost:9090/dogs/getDogById/{dogId}", Dogs.class, dogId);
	}

	public ResponseEntity<Dogs> getDogsByIdEntity(Long dogId) {
		return restTemplate.getForEntity("http://localhost:9090/dogs/getDogById/{dogId}", Dogs.class, dogId);
	}
	
	public ResponseEntity<Dogs> getDogsByIdExchange(Long dogId) {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity <String> httpEntity = new HttpEntity<String>(headers);
		return restTemplate.exchange("http://localhost:9090/dogs/getDogById/{dogId}", HttpMethod.GET, httpEntity, Dogs.class, dogId);
	}

	public Dogs postDogsObject(Dogs dogs) {
		return restTemplate.postForObject("http://localhost:9090/dogs/saveDogs", dogs, Dogs.class);
	}

	public ResponseEntity<Dogs> postDogsEntity(Dogs dogs) {
		return restTemplate.postForEntity("http://localhost:9090/dogs/saveDogs", dogs, Dogs.class);
	}
	
	public ResponseEntity<Dogs> postDogsExchange(Dogs dogs) {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity <Dogs> httpEntity = new HttpEntity<Dogs>(dogs, headers);
		return restTemplate.exchange("http://localhost:9090/dogs/saveDogs", HttpMethod.POST , httpEntity, Dogs.class);
	}
	
	public List<Dogs> putDogs(Dogs dogs) {
		restTemplate.put("http://localhost:9090/dogs/updateDogs", dogs, Dogs.class);
		return getAllDogsEntity();
	}
	
	public ResponseEntity<Dogs> putDogsExchange(Dogs dogs) {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity <Dogs> httpEntity = new HttpEntity<Dogs>(dogs, headers);
		return restTemplate.exchange("http://localhost:9090/dogs/updateDogs", HttpMethod.PUT , httpEntity, Dogs.class);
	}
	
	public List<Dogs> deleteDogById(Long dogId) {
		restTemplate.delete("http://localhost:9090/dogs/removeDog/{dogId}", dogId);
		return getAllDogsEntity();
	}
	
	public List<Dogs> deleteDogByIdExchange(Long dogId) {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity <Dogs> httpEntity = new HttpEntity<Dogs>(headers);
		restTemplate.exchange("http://localhost:9090/dogs/removeDog/{dogId}", HttpMethod.DELETE , httpEntity, Void.class, dogId);
		return getAllDogsEntity();
	}

}
