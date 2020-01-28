package ru.jurfed.sptingdatajpa.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.jurfed.sptingdatajpa.domain.Address;
import ru.jurfed.sptingdatajpa.domain.Person;

import java.util.List;

@Repository("address")
public interface AddressRepository extends CrudRepository<Address, Integer>, CustomizedPerson {

    List<Address> findAll();

    Address findByAddress(String address);

}
