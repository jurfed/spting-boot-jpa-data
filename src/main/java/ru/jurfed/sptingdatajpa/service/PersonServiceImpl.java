package ru.jurfed.sptingdatajpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.jurfed.sptingdatajpa.domain.Person;
import ru.jurfed.sptingdatajpa.repositories.PersonRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService{

    @Autowired
    PersonRepository personRepository;

    @Override
    public void simpleTests() {
        System.err.println("\n------------------------------all finded persons------------------------------");
        personRepository.save(new Person("Ivan", "Pushkin"));
        personRepository.save(new Person("Elena","Ivanova"));
        List<Person> personList = personRepository.findAll();
        personList.forEach(person -> System.err.println(person));

        System.err.println("\n------------------------------find person by name------------------------------");
        personRepository.save(new Person("Pavel","Petrov"));
        personRepository.save(new Person("Kostya","Sidorov"));
        Person findedPerson = personRepository.findBySurname("Petrov");
        System.err.println(findedPerson);

        System.err.println("\n------------------------------sorted persons------------------------------");
        personRepository.save(new Person("Mariya","Zvezdnay"));
        personRepository.save(new Person("Iliya","Abramov"));
        List<Person> sortedPerson = personRepository.findAll(Sort.by(Sort.Direction.ASC, "name", "id"));
        sortedPerson.forEach(person -> System.err.println(person));

        System.err.println("\n------------------------------Pageable persons------------------------------");
        Page<Person> pageablePersons = personRepository.findAll(PageRequest.of(1,3));
        pageablePersons.forEach(person -> System.err.println(person));


        System.err.println("\n------------------------------Save all------------------------------");
        Person p1 = new Person("Name 1","Surname 1");
        Person p2 = new Person("Name 2","Surname 2");
        Person p3 = new Person("Name 3","Surname 3");
        Person p4 = new Person("Name 4","Surname 4");

        List<Person> personList1 = new ArrayList<>();
        personList1.add(p1);
        personList1.add(p2);
        personList1.add(p3);
        personList1.add(p4);
        personRepository.saveAll(personList1);
        personRepository.findAll().stream().sorted((o1, o2) -> o1.getName().compareTo(o2.getName())).peek(System.err::println).collect(Collectors.toList()) ;

        System.err.println("\n------------------------------Delete some persons------------------------------");
        personRepository.deleteAll(personList1);
        personRepository.findAll().forEach(System.err::println);

        System.err.println("\n------------------------------Query------------------------------");
        Person person = personRepository.customFind("Petrov");
        System.err.println(person);

        System.err.println("\n------------------------------Custom method------------------------------");
        Person person1 = personRepository.findPersonByMaxId();
        System.err.println(person1);
    }
}
