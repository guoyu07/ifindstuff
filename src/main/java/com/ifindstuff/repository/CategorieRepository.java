package com.ifindstuff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ifindstuff.model.Categorie;



@Repository("categorieRepository")
public interface CategorieRepository extends CrudRepository<Categorie, Integer>{
	Categorie findByName(String name);
}
