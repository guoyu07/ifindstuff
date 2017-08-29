package com.ifindstuff.service;

import java.util.List;

import com.ifindstuff.model.Categorie;
import com.ifindstuff.model.Produit;
import com.ifindstuff.model.Store;
import com.ifindstuff.model.User;

public interface GestionService {

//	Store
	
	public List<Store> findStoreByUser(User user); 
	public Store findStoreByName(String name);
	public void saveStore(Store store, String nameUser);
	public void updateStore(Store store);
	public void validStore(Store store);
	public Store findStoreById(int idStore);
	public List<Store> findAllStores();
	
//	Produit
	
	public void saveProduit(Produit produit);
	void updateProduit(Produit produit);
	public Produit findProduitById(int idProduit);
	
//	Categorie
	
	public List<Categorie> findAllCategorie();
	public Categorie findCategorieByName(String categorieName);
	
	
}
