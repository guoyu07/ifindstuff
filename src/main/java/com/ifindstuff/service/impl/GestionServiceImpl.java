package com.ifindstuff.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifindstuff.model.Categorie;
import com.ifindstuff.model.Produit;
import com.ifindstuff.model.Role;
import com.ifindstuff.model.Store;
import com.ifindstuff.model.User;
import com.ifindstuff.repository.CategorieRepository;
import com.ifindstuff.repository.ProduitRepository;
import com.ifindstuff.repository.StoreRepository;
import com.ifindstuff.repository.UserRepository;
import com.ifindstuff.service.GestionService;

import java.util.List;
import java.util.Set;

@Service("gestionService")
public class GestionServiceImpl implements GestionService {

	@Autowired
	private StoreRepository storeRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ProduitRepository produitRepository;
	@Autowired
	private CategorieRepository categorieRepository;
	

	private static int i = 20;
//	Store
	
	


	@Override
	public List<Store> findStoreByUser(User user) {
		if(user.hasRole("ADMIN"))
			return (List<Store>) storeRepository.findAll();
		else
			return user.getStore();
	}
	
	@Override
	public Store findStoreByName(String name) {
		return storeRepository.findByName(name);
	}

	@Override
	public void saveStore(Store store, String nameUser) {
		User user;
		user = userRepository.findByEmail(nameUser);
		store.setUser(user);
		storeRepository.save(store);
	}
	

	@Override
	public void updateStore(Store store) {
		storeRepository.save(store);
	}
	
	@Override
	public void validStore(Store store) {
		store.setActive(true);
		storeRepository.save(store);
		
	}

	@Override
	public Store findStoreById(int idStore) {
		
		return storeRepository.findOne(idStore);
		
	}

	
	
//	Produit
	
	
	@Override
	public void saveProduit(Produit produit) {
		Produit prodCreated = produit;
		prodCreated.setId(i);
		produitRepository.save(prodCreated);
		i = i + 1;
			
	}


	@Override
	public void updateProduit(Produit produit) {
		produitRepository.save(produit);
	}

	
	@Override
	public Produit findProduitById(int idProduit) {
		return produitRepository.findOne(idProduit);
	}
	
	
//  Categorie
	
	@Override
	public List<Categorie> findAllCategorie() {
		return (List<Categorie>) categorieRepository.findAll();
	}

	@Override
	public Categorie findCategorieByName(String categorieName) {
		return categorieRepository.findByName(categorieName);
	}

	

	
}
