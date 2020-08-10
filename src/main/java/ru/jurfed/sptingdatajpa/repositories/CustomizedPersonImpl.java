package ru.jurfed.sptingdatajpa.repositories;

import ru.jurfed.sptingdatajpa.domain.Person;
import ru.jurfed.sptingdatajpa.domain.PersonAndGroup;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class CustomizedPersonImpl implements CustomizedPerson{

    @PersistenceContext
    private EntityManager em;

    @Override
    public Person findPersonByMaxId() {
        Query result = em.createQuery("select person from Person person where person.id=(select max(p2.id) from Person p2)");
        Person person = (Person) result.getSingleResult();
        return person;
    }


}
