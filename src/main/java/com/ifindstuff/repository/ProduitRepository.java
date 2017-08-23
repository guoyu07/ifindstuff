package com.ifindstuff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ifindstuff.model.Produit;

@Repository("produitRepository")
public interface ProduitRepository extends CrudRepository<Produit, Integer>{
	Produit findByName(String name);
}
