package ru.jurfed.sptingdatajpa;

import jdk.management.cmm.SystemResourcePressureMXBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import ru.jurfed.sptingdatajpa.domain.Person;
import ru.jurfed.sptingdatajpa.repositories.PersonRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class SptingDataJpaApplication {


    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(SptingDataJpaApplication.class, args);
        PersonRepository repository = (PersonRepository) context.getBean("person");

		System.err.println("\n------------------------------all finded persons------------------------------");
        repository.save(new Person("Ivan", "Pushkin"));
        repository.save(new Person("Elena","Ivanova"));
        List<Person> personList = repository.findAll();
        personList.forEach(person -> System.err.println(person));

		System.err.println("\n------------------------------find person by name------------------------------");
        repository.save(new Person("Pavel","Petrov"));
        repository.save(new Person("Kostya","Sidorov"));
        Person findedPerson = repository.findBySurname("Petrov");
        System.err.println(findedPerson);

		System.err.println("\n------------------------------sorted persons------------------------------");
		repository.save(new Person("Mariya","Zvezdnay"));
		repository.save(new Person("Iliya","Abramov"));
        List<Person> sortedPerson = repository.findAll(Sort.by(Sort.Direction.ASC, "name", "id"));
        sortedPerson.forEach(person -> System.err.println(person));

		System.err.println("\n------------------------------Pageable persons------------------------------");
		Page<Person> pageablePersons = repository.findAll(PageRequest.of(1,3));
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
        repository.saveAll(personList1);
        repository.findAll().stream().sorted((o1, o2) -> o1.getName().compareTo(o2.getName())).peek(System.err::println).collect(Collectors.toList()) ;

        System.err.println("\n------------------------------Delete some persons------------------------------");
        repository.deleteAll(personList1);
        repository.findAll().forEach(System.err::println);

        System.err.println("\n------------------------------Query------------------------------");
        Person person = repository.customFind("Petrov");
        System.err.println(person);

        System.err.println("\n------------------------------Custom method------------------------------");
        Person person1 = repository.findPersonByMaxId();
        System.err.println(person1);
    }

}
