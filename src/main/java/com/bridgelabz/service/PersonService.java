package com.bridgelabz.service;

import java.util.List;
import java.util.Objects;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.bridgelabz.dto.PersonDto;
import com.bridgelabz.entity.Person;
import com.bridgelabz.repository.PersonRepository;
import com.bridgelabz.util.Response;


@Service
public class PersonService implements IPersonService {

	@Autowired
	PersonRepository personRepository;

	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
    private MessageSource messageSource;

	@Override
	public Response addPersonDetails(PersonDto personDto) {
		Person person = modelMapper.map(personDto, Person.class);
		Person personRes = personRepository.save(person);
		Response res = new Response();
		res.setData(personRes);
		res.setMessage(messageSource.getMessage("addressbook.addressAddded.message", null, null, null));
		res.setStatusCode(200);
		return res;
	}

	@Override
	public void deletePersonDetails(Long id) {
		personRepository.deleteById(id);
	}

	@Override
	public List<Person> fetchPersonList() {
		return (List<Person>) personRepository.findAll();
	}

	@Override
	public Person getPersonDetails(Long personID) {
		return personRepository.getById(personID);
	}

	@Override
	public Person updatePersonDetails(Long personId, PersonDto personDto) {
		Person personDb = personRepository.getById(personId);
		if (personDb != null) {
			
			if (Objects.nonNull(personDto.getAddress()) && personDto.getAddress() != "") {
				personDb.setAddress(personDto.getAddress());
			}
			
			
			if (Objects.nonNull(personDto.getCity()) && personDto.getCity() != "") {
				personDb.setCity(personDto.getCity());
			}
			
			if (Objects.nonNull(personDto.getFullName()) && personDto.getFullName() != "") {
				personDb.setFullName(personDto.getFullName());
			}
			
			if (Objects.nonNull(personDto.getPhoneNumber())) {
				personDb.setPhoneNumber(personDto.getPhoneNumber());
			}
			
			if (Objects.nonNull(personDto.getState()) && personDto.getState() != "") {
				personDb.setState(personDto.getState());
			}
			
			if (Objects.nonNull(personDto.getZipCode()) && personDto.getZipCode() != "") {
				personDb.setZipCode(personDto.getZipCode());
			}

			return personRepository.save(personDb);
		}

		return null;
	}

	@Override
	public List getPersonSnoreName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
