package com.ifindstuff.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class IndexController {

	
	@RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("title", "Index - I find Struff");
        return "index";
	}
}
