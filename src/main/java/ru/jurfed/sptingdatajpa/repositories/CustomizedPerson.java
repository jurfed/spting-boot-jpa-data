package ru.jurfed.sptingdatajpa.repositories;

import ru.jurfed.sptingdatajpa.domain.Person;

public interface CustomizedPerson {

    Person findPersonByMaxId();

}