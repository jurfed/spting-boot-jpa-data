package ru.jurfed.sptingdatajpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.jurfed.sptingdatajpa.domain.Person;

import java.util.List;

@Repository("person")
public interface PersonRepository extends CrudRepository<Person, Integer> {

    List<Person> findAll();

    Person findByName(String name);
}
