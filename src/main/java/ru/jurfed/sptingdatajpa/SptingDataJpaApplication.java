package ru.jurfed.sptingdatajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import ru.jurfed.sptingdatajpa.domain.Person;
import ru.jurfed.sptingdatajpa.repositories.PersonRepository;

import java.util.List;

@SpringBootApplication
public class SptingDataJpaApplication {


	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SptingDataJpaApplication.class, args);
		PersonRepository repository = (PersonRepository) context.getBean("person");
		repository.save(new Person("Pushkin"));
		repository.save(new Person("Ivanova"));
		List<Person> personList = repository.findAll();
		personList.forEach(person -> System.err.println(person));

		repository.save(new Person("Petrov"));
		repository.save(new Person("Sidorov"));
		Person person = repository.findByName("Petrov");
		System.err.println(person);
	}

}
