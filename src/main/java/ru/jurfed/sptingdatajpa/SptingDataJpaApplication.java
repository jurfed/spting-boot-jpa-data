package ru.jurfed.sptingdatajpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.jurfed.sptingdatajpa.service.PersonServiceImpl;

@SpringBootApplication
public class SptingDataJpaApplication {


    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(SptingDataJpaApplication.class, args);
        PersonServiceImpl personService = context.getBean(PersonServiceImpl.class);
        personService.simpleTests();

        personService.oneToOne1();
        personService.oneToOne2();
        personService.oneToOne3();

        personService.oneToMany1();
        personService.oneToMany2();
//        PersonRepository repository = (PersonRepository) context.getBean("person");


    }

}
