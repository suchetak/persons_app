package com.example.backend;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PersonController {

	@Autowired
	PersonService personService;

	@GetMapping(path = "/persons")
	private List<Person> getAllPersons() {
		return personService.getAllPersons();
	}

	@GetMapping(path = "/persons", params = { "name" })
	private List<Person> getPerson(@RequestParam(name = "name") String name) {
		return personService.getPersonByName(name);
	}

}