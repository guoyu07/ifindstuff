package com.ifindstuff.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ifindstuff.model.Produit;
import com.ifindstuff.model.User;
import com.ifindstuff.service.UserService;

@Controller
@RequestMapping("")
public class IndexController {

	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value="/index", method = RequestMethod.GET)
	public ModelAndView home(){
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		modelAndView.setViewName("index");
		return modelAndView;
	}
	
	@RequestMapping(value="/profil", method = RequestMethod.GET)
	public ModelAndView showProfil(){
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("user", user);
		modelAndView.setViewName("profil");
		return modelAndView;
	}
	
	@RequestMapping(value="/editProfil", method = RequestMethod.GET)
	public ModelAndView editProfil(){
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("userCurrent", user);
		modelAndView.setViewName("editProfil");
		return modelAndView;
	}
	
	@RequestMapping(value="/editProfil", method = RequestMethod.POST)
	public ModelAndView updateProfil(Model model, @ModelAttribute @Valid User user, Errors errors, Principal principal){
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User userCurrent = userService.findUserByEmail(auth.getName());
		
		userCurrent.setName(user.getName());
		userCurrent.setLastName(user.getLastName());
		
		userService.saveUser(userCurrent);
		
		modelAndView.setViewName("redirect:/profil");
		return modelAndView;
	}
}
