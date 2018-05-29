package com.wagawin.demo.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.wagawin.demo.model.House;

public interface HouseRepository extends PagingAndSortingRepository<House, Long> {

	Optional<House> findByOwnerId(long personId);
}