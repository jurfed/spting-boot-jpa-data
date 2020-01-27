package ru.jurfed.sptingdatajpa;

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

import java.util.List;

@SpringBootApplication
public class SptingDataJpaApplication {


    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(SptingDataJpaApplication.class, args);
        PersonRepository repository = (PersonRepository) context.getBean("person");

		System.err.println("\nall finded persons");
        repository.save(new Person("Pushkin"));
        repository.save(new Person("Ivanova"));
        List<Person> personList = repository.findAll();
        personList.forEach(person -> System.err.println(person));

		System.err.println("\nfind person by name");
        repository.save(new Person("Petrov"));
        repository.save(new Person("Sidorov"));
        Person findedPerson = repository.findByName("Petrov");
        System.err.println(findedPerson);

		System.err.println("\nsorted persons:");
		repository.save(new Person("Zvezdnayz"));
		repository.save(new Person("Abramov"));
        List<Person> sortedPerson = repository.findAll(Sort.by(Sort.Direction.ASC, "name", "id"));
        sortedPerson.forEach(person -> System.err.println(person));

		System.err.println("\nPageable persons:");
		Page<Person> pageablePersons = repository.findAll(PageRequest.of(1,3));
		pageablePersons.forEach(person -> System.err.println(person));

		System.err.println("\nQuery:");
    }

}
