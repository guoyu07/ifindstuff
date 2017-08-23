package com.ifindstuff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ifindstuff.model.City;



@Repository("cityRepository")
public interface CityRepository extends CrudRepository<City, Long>{
	City findByName(String name);
}
