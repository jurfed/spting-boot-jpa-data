package ru.jurfed.sptingdatajpa.repositories;

import ru.jurfed.sptingdatajpa.domain.Person;
import ru.jurfed.sptingdatajpa.domain.PersonAndGroup;

import java.util.List;

public interface CustomizedPerson {

    Person findPersonByMaxId();

}