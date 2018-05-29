package com.wagawin.demo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.wagawin.demo.model.ParentSummary;

public interface ParentSummaryRepository extends PagingAndSortingRepository<ParentSummary, Long> {
	  
}
