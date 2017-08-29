package com.ifindstuff.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ifindstuff.service.GestionService;
import com.ifindstuff.model.Store;

@RestController
public class DataRestController {
	
	@Autowired 
	GestionService gestionService;
	
	
	@RequestMapping(value = "/apiIFindStuff", method = RequestMethod.GET)
    public ResponseEntity<List<Store>> listAllStores() {
        List<Store> stores = gestionService.findAllStores();
        if(stores.isEmpty()){
            return new ResponseEntity<List<Store>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Store>>(stores, HttpStatus.OK);
    }
	
}
