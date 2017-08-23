package com.ifindstuff.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ifindstuff.model.Produit;
import com.ifindstuff.model.Store;
import com.ifindstuff.model.User;
import com.ifindstuff.service.GestionService;
import com.ifindstuff.service.UserService;

@Controller
public class StoreController {

	@Autowired
	GestionService gestionService;
	
	@Autowired
	UserService userService;
	
	
	@RequestMapping(value={"/store"}, method = RequestMethod.GET)
	public ModelAndView showStore(@Valid Principal principal){
		List<Store> storeSearch = userService.findUserByEmail(principal.getName()).getStore();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("stores", storeSearch);
		modelAndView.setViewName("store");
		return modelAndView;
	}
	
	
	@RequestMapping(value={"/addStore"}, method = RequestMethod.GET)
	public ModelAndView showFormStore(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("formStore");
		Store store = new Store();
		modelAndView.addObject("store", store);
		return modelAndView;
	}
	
	@RequestMapping(value = "/addStore", method = RequestMethod.POST)
	public ModelAndView createNewStore(@Valid Store store, BindingResult bindingResult, Principal principal) {
		ModelAndView modelAndView = new ModelAndView();
		Store storeExist = gestionService.findStoreByName(store.getName());
		if (storeExist != null) {
			bindingResult
					.rejectValue("name", "error.store",
							"There is already a store registered with the name provided");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("formStore");
		} else {
			gestionService.saveStore(store, principal.getName());
			modelAndView.addObject("successMessage", "Store has been registered successfully");
			modelAndView.addObject("store", new Store());
			modelAndView.setViewName("formStore");
			
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "{id}/addProduit", method = RequestMethod.GET)
    private ModelAndView updateGet(Model model, @PathVariable String id, Principal principal){
		ModelAndView modelAndView = new ModelAndView();
        Produit produit = new Produit();
        modelAndView.setViewName("formProduit");
        modelAndView.addObject("store", gestionService.findStoreById(Integer.parseInt(id)));
		modelAndView.addObject("produit", produit);
        return modelAndView;
	}
	
	@RequestMapping(value = "{id}/addProduit", method = RequestMethod.POST)
    public ModelAndView updatePost(Model model, @PathVariable String id, @ModelAttribute @Valid Produit produit, Errors errors, Principal principal) {
		ModelAndView modelAndView = new ModelAndView();
		if (errors.hasErrors()) {
            model.addAttribute("title", "Edit project");
            model.addAttribute("error", "error");
            modelAndView.setViewName("formProduit");
            return modelAndView;
        }
        
		Store store;
        store = gestionService.findStoreById(Integer.parseInt(id));
        produit.setStore(store);
        gestionService.saveProduit(produit);
        modelAndView.setViewName("redirect:/store");
        return modelAndView;
	
		}
}