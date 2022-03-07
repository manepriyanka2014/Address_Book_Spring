package com.bridgelabz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.validation.Valid;

import com.bridgelabz.dto.PersonDto;
import com.bridgelabz.entity.Person;
import com.bridgelabz.service.IPersonService;
import com.bridgelabz.util.Response;
import com.bridgelabz.exceptionHandler.UserNotFoundException;

@RestController
@RequestMapping("/addressbook")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonController {

	// Annotation
	@Autowired
	private IPersonService personService;

	@PostMapping("/register")
	public ResponseEntity<?> addPerson(@Valid @RequestBody PersonDto personDto) {
		Response response = personService.addPersonDetails(personDto);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deletePerson(@Valid @PathVariable("id") Long personId) {
		personService.deletePersonDetails(personId);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Person> updatePersonDetails(@RequestBody PersonDto personDto,
			@PathVariable("id") Long personId) throws UserNotFoundException {
		Person personDB = personService.updatePersonDetails(personId, personDto);
		return new ResponseEntity<Person>(personDB, HttpStatus.OK);
	}

	@GetMapping("/get")
	public ResponseEntity<List> fetchPersonList() throws UserNotFoundException {
		return new ResponseEntity<List>(personService.fetchPersonList(), HttpStatus.OK);
	}

}
