package com.wagawin.demo.repository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.wagawin.demo.model.Child;
import com.wagawin.demo.model.Summery;

public interface ChildRepository extends PagingAndSortingRepository<Child, Long> {
	List<Child> findAllByParentId(Long personId);
    List<Child> findByName(String name);   
    
	
    @Query("SELECT new com.wagawin.demo.model.Summery(parent.id as parentId, count(parent.id) as chidlrenCount) from Child group by parent.id order by chidlrenCount")
    List<Summery> getSummery();    
    
}
