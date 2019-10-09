package com.example.backend;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, String> {

	@Query("SELECT p FROM Person p WHERE p.firstName = ?1 OR p.lastName=?1")
	List<Person> findByFirstNameOrLastName(String name);
}
