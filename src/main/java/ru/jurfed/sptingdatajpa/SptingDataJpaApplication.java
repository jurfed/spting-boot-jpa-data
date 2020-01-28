package ru.jurfed.sptingdatajpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import ru.jurfed.sptingdatajpa.domain.Person;
import ru.jurfed.sptingdatajpa.repositories.PersonRepository;
import ru.jurfed.sptingdatajpa.service.PersonServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class SptingDataJpaApplication {


    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(SptingDataJpaApplication.class, args);
        PersonServiceImpl personService = context.getBean(PersonServiceImpl.class);
        personService.simpleTests();
        personService.simpleTests2();
//        PersonRepository repository = (PersonRepository) context.getBean("person");


    }

}
