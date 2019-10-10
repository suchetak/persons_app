package com.example.backend;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.ArrayList;

@Service
public class PersonService {

	@Autowired
	PersonRepository personRepository;

	public List<Person> getAllPersons() {
		List<Person> persons = new ArrayList<Person>();
		personRepository.findAll().forEach(person -> persons.add(person));
		return persons;
	}

	public Person getPersonById(String id) {
		return personRepository.findById(id).get();
	}

	public List<Person> getPersonByName(String name) {
		return personRepository.findByFirstNameOrLastName(name.toUpperCase());
	}

}