package com.ifindstuff.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ifindstuff.service.GestionService;
import com.ifindstuff.model.Categorie;
import com.ifindstuff.model.Store;

@RestController
public class DataRestController {
	
	@Autowired 
	GestionService gestionService;
	
	
	@RequestMapping(value = "/apiIFindStore", method = RequestMethod.GET)
	@CrossOrigin(origins = {"http://localhost:8100","file://"})
    public ResponseEntity<List<Store>> listAllStores() {
        List<Store> stores = gestionService.findAllStores();
        if(stores.isEmpty()){
            return new ResponseEntity<List<Store>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Store>>(stores, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/apiIFindCategorie", method = RequestMethod.GET)
	@CrossOrigin(origins = {"http://localhost:8100","file://"})
    public ResponseEntity<List<Categorie>> listAllCategorie() {
        List<Categorie> categories = gestionService.findAllCategorie();
        if(categories.isEmpty()){
            return new ResponseEntity<List<Categorie>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Categorie>>(categories, HttpStatus.OK);
    }
	
	
}
