package ru.jurfed.sptingdatajpa.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.jurfed.sptingdatajpa.domain.Person;
import ru.jurfed.sptingdatajpa.domain.PersonAndGroup;

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

    @Query(value = "select p.person_name, count(p.person_name) from Person p group by p.person_name", nativeQuery = true)
    List<Object[]> findByNameAndGroup();

/*
    @Query(value = "select new ru.jurfed.sptingdatajpa.domain.PersonAndGroup(p.person_name, count(p.person_name)) from Person AS p group by p.person_name", nativeQuery = true)
    List<PersonAndGroup> findByNameAndGroup2();
*/




}
