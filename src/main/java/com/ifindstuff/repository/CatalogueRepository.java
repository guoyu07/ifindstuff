package com.ifindstuff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ifindstuff.model.Catalogue;



@Repository("catalogueRepository")
public interface CatalogueRepository extends CrudRepository<Catalogue, Integer>{
	Catalogue findByName(String name);
}
