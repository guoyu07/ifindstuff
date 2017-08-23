package com.ifindstuff.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifindstuff.model.Store;
import com.ifindstuff.model.User;
import com.ifindstuff.repository.StoreRepository;
import com.ifindstuff.repository.UserRepository;
import com.ifindstuff.service.GestionService;

@Service("gestionService")
public class GestionServiceImpl implements GestionService {

	@Autowired
	private StoreRepository storeRepository;
	@Autowired
	private UserRepository userRepository;
	
	
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
	public void validStore(Store store) {
		store.setActive(true);
		storeRepository.save(store);
		
	}

}
