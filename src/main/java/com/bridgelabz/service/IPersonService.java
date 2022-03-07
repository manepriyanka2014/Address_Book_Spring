package com.bridgelabz.service;

import java.util.List;

import com.bridgelabz.dto.PersonDto;
import com.bridgelabz.entity.Person;
import com.bridgelabz.util.Response;

public interface IPersonService {

	public Response addPersonDetails(PersonDto personDto);

	public void deletePersonDetails(Long id);

	public List<Person> fetchPersonList();

	public Person getPersonDetails(Long personID);

	public Person updatePersonDetails(Long personID,PersonDto personDto);

	public List getPersonSnoreName();
	
	

}
