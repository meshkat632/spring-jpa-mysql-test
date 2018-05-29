package com.wagawin.demo.controller;

import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wagawin.demo.exception.ResourceNotFoundExcption;
import com.wagawin.demo.model.Child;
import com.wagawin.demo.model.ChildInfo;
import com.wagawin.demo.model.House;
import com.wagawin.demo.model.Person;
import com.wagawin.demo.repository.ChildRepository;
import com.wagawin.demo.repository.HouseRepository;
import com.wagawin.demo.repository.PersonRepository;


@RestController
public class PersonController {
	
	private final static Logger LOGGER = Logger.getLogger(PersonController.class.getName());

	private static final int PAGE_SIZE = 5;

	@Autowired
	PersonRepository repository;
	
	@Autowired
	HouseRepository houseRepository;
	
	@Autowired
	ChildRepository childRepository;


	@GetMapping(path = "/person/all")
	public Iterable<Person> getAll(@RequestParam("pageNumber") int pageNumber) {
		PageRequest request = PageRequest.of(pageNumber, PAGE_SIZE, Sort.Direction.DESC, "name");
		return repository.findAll(request);
	}
	
	@GetMapping(path = "/person/{id}/")
	public Person getPersonById(@PathVariable("id") Long id) {		
		Optional<Person> person = repository.findById(id);
		if(person.isPresent()) return person.get();
		else {
			throw new ResourceNotFoundExcption("person with id: " + id + " not found");
		} 
	}
	@GetMapping(path = "/person/{id}/house")
	public House getHouseByOwnerId(@PathVariable("id") Long id) {
		Optional<House> house = houseRepository.findByOwnerId(id);
		if(house.isPresent()) return house.get();
		else {
			throw new ResourceNotFoundExcption("house with owner id: " + id + " not found");
		} 
	}
	@GetMapping(path = "/person/{id}/children")
	public Iterable<Child> getChildrenByParentId(@PathVariable("id") Long id) {		
		return childRepository.findAllByParentId(id);		
	}
	
	@GetMapping(path = "/house/all")
	public Iterable<House> getAllHouse(@RequestParam("pageNumber") int pageNumber) {
		PageRequest request = PageRequest.of(pageNumber, PAGE_SIZE, Sort.Direction.DESC, "address");
		return houseRepository.findAll(request);
	}
	
	@GetMapping(path = "/house")
	public House getAll(@RequestParam("personId") Long personId) {
		Optional<House> house = houseRepository.findByOwnerId(personId);
		if(house.isPresent()) return house.get();
		else {
			throw new ResourceNotFoundExcption("house with owner id: " + personId + " not found");
		}
	}
	
	@GetMapping(path = "/child/info")
	public ChildInfo getChild(@RequestParam("id") Long id) {
		Optional<Child> child = childRepository.findById(id);
		if(child.isPresent()) {
			Child _child = child.get();
			return new ChildInfo(_child,_child.getParent(), _child.getFavoriteMeals().get(0));			
		}
		else {
			throw new ResourceNotFoundExcption("child with id: " + id + " not found");
		}
	}

}
