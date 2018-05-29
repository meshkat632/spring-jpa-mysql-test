package com.wagawin.demo.repository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.wagawin.demo.model.Person;

public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

    List<Person> findByName(String name);
    
    
    @Query("SELECT AVG(p.age) from Person p")
    int getAverageAge();    
    
    /*
    @Query("select new map(count(v) as cnt, v.answer) from Person p group by v.answer")
    public List<?> findChildrenCount();
    */
    
   
}