package com.ifindstuff.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ifindstuff.model.Store;
import com.ifindstuff.service.StoreService;

@Controller
public class StoreController {

	@Autowired
	StoreService storeService;
	
	
	
	@RequestMapping(value = "/store", method = RequestMethod.GET)
    public String index(Model model, Principal principal) {
        model.addAttribute("title", "Projects");
        return "store";
	}
	
	@RequestMapping(value = "/addStore", method = RequestMethod.GET)
    public String newGet(Model model) {
        model.addAttribute("title", "Add store");
        model.addAttribute("store", new Store());
        return "form";
	}
	
	@RequestMapping(value = "/addStore", method = RequestMethod.POST)
    public String newPost(Model model, @ModelAttribute @Valid Store store, Errors errors, Principal principal) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add project");
            model.addAttribute("error", "error");
            return "form";
        }
        storeService.saveStore(store, principal.getName());
        return "index";
	}
}
