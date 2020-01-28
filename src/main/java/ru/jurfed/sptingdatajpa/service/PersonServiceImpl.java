package ru.jurfed.sptingdatajpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.jurfed.sptingdatajpa.domain.Address;
import ru.jurfed.sptingdatajpa.domain.Email;
import ru.jurfed.sptingdatajpa.domain.Person;
import ru.jurfed.sptingdatajpa.repositories.AddressRepository;
import ru.jurfed.sptingdatajpa.repositories.PersonRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    AddressRepository addressRepository;

    @Override
    public void simpleTests() {
        System.err.println("\n------------------------------all finded persons------------------------------");
        personRepository.saveAndFlush(new Person("Ivan", "Pushkin"));
        personRepository.saveAndFlush(new Person("Elena", "Ivanova"));
        List<Person> personList = personRepository.findAll();
        personList.forEach(person -> System.err.println(person));

        System.err.println("\n------------------------------find person by name------------------------------");
        personRepository.saveAndFlush(new Person("Pavel", "Petrov"));
        personRepository.saveAndFlush(new Person("Kostya", "Sidorov"));
        Person findedPerson = personRepository.findBySurname("Petrov");
        System.err.println(findedPerson);

        System.err.println("\n------------------------------sorted persons------------------------------");
        personRepository.saveAndFlush(new Person("Mariya", "Zvezdnay"));
        personRepository.saveAndFlush(new Person("Iliya", "Abramov"));
        List<Person> sortedPerson = personRepository.findAll(Sort.by(Sort.Direction.ASC, "name", "id"));
        sortedPerson.forEach(person -> System.err.println(person));

        System.err.println("\n------------------------------Pageable persons------------------------------");
        Page<Person> pageablePersons = personRepository.findAll(PageRequest.of(1, 3));
        pageablePersons.forEach(person -> System.err.println(person));


        System.err.println("\n------------------------------Save all------------------------------");
        Person p1 = new Person("Name 1", "Surname 1");
        Person p2 = new Person("Name 2", "Surname 2");
        Person p3 = new Person("Name 3", "Surname 3");
        Person p4 = new Person("Name 4", "Surname 4");

        List<Person> personList1 = new ArrayList<>();
        personList1.add(p1);
        personList1.add(p2);
        personList1.add(p3);
        personList1.add(p4);
        personRepository.saveAll(personList1);
        personRepository.findAll().stream().sorted((o1, o2) -> o1.getName().compareTo(o2.getName())).peek(System.err::println).collect(Collectors.toList());

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

    @Override
    @Transactional
    public void oneToOne1() {

        System.err.println("\n----------------------- One to One");
        Address address = new Address("Obuhova oborona 26");
        Address address2 = new Address("Petrovskaya 76");
//        addressRepository.saveAndFlush(address);
        Person person = new Person("Kuzya", "Ruzymin", address);
        Person person2 = new Person("New person", "New surname", address2);
        personRepository.saveAndFlush(person);
        personRepository.saveAndFlush(person2);
        personRepository.findAllByAddressIsNotNull().forEach(System.err::println);


//        Person person3 = personRepository.findBySurname("Ruzymin");
//        person3.setAddress(new Address("Kupchino 47"));
//        personRepository.save(person3);

    }

    @Override
    public void oneToOne2() {
        System.err.println("\n----------------------- One to One + modify name and address");
        Person person1 = personRepository.findBySurname("Ruzymin");
        person1.setName("Super Kuzya!");
        Address address1 = person1.getAddress();
        address1.setAddress("Kuzin dom 26");
        personRepository.saveAndFlush(person1);
        personRepository.findAllByAddressIsNotNull().forEach(System.err::println);
    }

    @Override
//    @Transactional
    public void oneToOne3() {
        System.err.println("\n----------------------- One to One + Delete address");
        Address address3 = addressRepository.findByAddress("Kuzin dom 26");
        addressRepository.delete(address3);
        personRepository.findAllByAddressIsNotNull().forEach(System.err::println);
    }

    @Override
    @Transactional
    public void oneToMany1() {
        Person person = personRepository.findBySurname("Pushkin");
        Email email1 = new Email("inbox@mail.ru");
        Email email2 = new Email("ivanov@mail.ru");
        List<Email> emails = new ArrayList<>();
        emails.add(email1);
        emails.add(email2);
        person.setEmails(emails);
        personRepository.saveAndFlush(person);

        Person person2 = personRepository.findBySurname("Zvezdnay");
        Email email11 = new Email("petrov@yandex.ru");
        Email email22 = new Email("ivanov@yandex.ru");
        List<Email> emails2 = new ArrayList<>();
        emails2.add(email11);
        emails2.add(email22);
        person2.setEmails(emails2);
        personRepository.saveAndFlush(person2);
    }

    @Override
    @Transactional
    public void oneToMany2() {
        System.err.println("\n----------------------- One to Many + find by one of email");
        Email email = new Email("petrov@yandex.ru");
        List<Person> people = personRepository.findByEmailsIsNotNull();
        people.forEach(System.err::println);

        System.err.println("\n----------------------- One to Many + find By Specific Email");
        List<Person> people2 = personRepository.findBySpecificEmail("petrov@yandex.ru");
        people2.forEach(System.err::println);


    }


}
