package com.ifindstuff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.ifindstuff.model.Categorie;



@Repository("categorieRepository")
public interface CategorieRepository extends CrudRepository<Categorie, Integer>{
	Categorie findByName(String name);
}
