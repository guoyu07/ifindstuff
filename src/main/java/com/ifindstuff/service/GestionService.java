package com.ifindstuff.service;

import com.ifindstuff.model.Store;

public interface GestionService {

	public Store findStoreByName(String name);
	public void saveStore(Store store, String nameUser);
	public void validStore(Store store);
}
