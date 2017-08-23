package com.ifindstuff.service;

import java.util.List;

import com.ifindstuff.model.Produit;
import com.ifindstuff.model.Store;

public interface GestionService {

//	Store
	
	
	public Store findStoreByName(String name);
	public void saveStore(Store store, String nameUser);
	public void validStore(Store store);
	public Store findStoreById(int idStore);
	
//	Produit
	
	public void saveProduit(Produit produit);
	public Produit findProduitById(int idProduit);
}
