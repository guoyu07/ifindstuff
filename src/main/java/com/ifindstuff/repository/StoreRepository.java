package com.ifindstuff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ifindstuff.model.Store;

@Repository("storeRepository")
public interface StoreRepository extends CrudRepository<Store, Integer>{
	Store findByName(String name);
}
