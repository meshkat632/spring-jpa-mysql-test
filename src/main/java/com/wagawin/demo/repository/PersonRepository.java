package com.wagawin.demo.repository;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.wagawin.demo.model.Person;

public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

    List<Person> findByName(String name);
}