package jwright75.springframework.spring5webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jwright75.springframework.spring5webapp.repositories.AuthorRepository;


import org.springframework.ui.Model;

@Controller
public class AuthorController {

	private final AuthorRepository authorRepository;
	
	public AuthorController(AuthorRepository authorRepository){
	
		this.authorRepository = authorRepository;
	}
	
	@RequestMapping("/authors")
	public String getAuthors(Model model){
		
		model.addAttribute("authors", authorRepository.findAll());
		
		return "authors/authorThyme";
	}
}
