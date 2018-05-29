package com.wagawin.demo.repository;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.wagawin.demo.model.Child;

public interface ChildRepository extends PagingAndSortingRepository<Child, Long> {
	List<Child> findAllByParentId(Long personId);
    List<Child> findByName(String name);
}