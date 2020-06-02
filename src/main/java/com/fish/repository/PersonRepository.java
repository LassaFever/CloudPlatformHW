package com.fish.repository;

import com.fish.domain.Person;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, String> {

    List<Person> findByLastname(String lastName);

    List<Person> findPersonByLastname(String lastName, Pageable pageable);

    List<Person> findByFirstnameAndLastname(String firstName, String lastName);

    List<Person> findByAdress_City(String city);

    List<Person> findByFamilyList_Username(String username);

}
