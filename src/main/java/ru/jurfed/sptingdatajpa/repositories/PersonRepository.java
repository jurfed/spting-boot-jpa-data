package ru.jurfed.sptingdatajpa.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.jurfed.sptingdatajpa.domain.Email;
import ru.jurfed.sptingdatajpa.domain.Person;

import java.util.List;

@Repository("person")
public interface PersonRepository extends JpaRepository<Person, Integer>, CustomizedPerson {

    List<Person> findAll();

    List<Person> findAll(Sort sort);

    Person findBySurname(String surname);

    Page<Person> findAll(Pageable pageable);

    @Query("select p from Person p where p.surname =:surname")
    Person customFind(@Param("surname") String n);

    List<Person> findAllByAddressIsNotNull();

    List<Person> findByEmailsIsNotNull();


    @Query("select p from Person p join p.emails r where r.email =:searchMail")
    List<Person> findBySpecificEmail(@Param("searchMail") String email);


}
