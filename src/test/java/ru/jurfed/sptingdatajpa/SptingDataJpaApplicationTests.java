package ru.jurfed.sptingdatajpa;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.jurfed.sptingdatajpa.domain.Person;
import ru.jurfed.sptingdatajpa.repositories.PersonRepository;

import static org.assertj.core.api.Assertions.assertThat;

//@SpringBootTest
@DataJpaTest
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE,connection = EmbeddedDatabaseConnection.H2)
class SptingDataJpaApplicationTests {

	@Autowired
	private TestEntityManager testEntityManager;

	@Autowired
	PersonRepository personRepository;

//	@Autowired
	@Test
	void contextLoads() {
		this.testEntityManager.merge(new Person(1,"Vasiliy", "Ivanov"));
		Person person = this.personRepository.findBySurname("Ivanov");
		assertThat(person.getName()).isEqualTo("Vasiliy");
		System.out.println();
	}

}
