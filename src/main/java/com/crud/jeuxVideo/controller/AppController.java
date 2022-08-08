package com.crud.jeuxVideo.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.crud.jeuxVideo.model.Genre;
import com.crud.jeuxVideo.model.GenreRepository;
import com.crud.jeuxVideo.model.Jeux;
import com.crud.jeuxVideo.model.JeuxRepository;

@Controller
public class AppController {

	@Autowired
	private JeuxRepository jeuxRepository;
	@Autowired
	private GenreRepository genreRepository;

	@GetMapping("/")
	public String viewHomePage(Model model) {
		return "accueil";
	}
    @GetMapping("/jeux")
	public String viewJeuxPage(Model model) {
		List<Genre> genre = genreRepository.findAll();
		ArrayList<Jeux> jeux = (ArrayList<Jeux>) jeuxRepository.findAll();
		Collections.sort(jeux, Comparator.comparing(Jeux::getJeux_Titre));
		model.addAttribute("genre", genre);
		model.addAttribute("jeux", jeux);
		return "jeux";
	}
	@GetMapping("/search")
	public String searchJeux(@RequestParam(name = "q", required = false)String searchText, Model model,@RequestParam(name = "g", required = false)Long genreS){
		List<Genre> genre = genreRepository.findAll();
		List<Jeux> searchedJeux = (searchText != null) ? jeuxRepository.searchJeux(searchText) : Collections.emptyList();
		List<Jeux> filteredByGenre = (genreS != null) ? jeuxRepository.filterByGenre(genreS) : Collections.emptyList();
		Collections.sort(searchedJeux, Comparator.comparing(Jeux::getJeux_Titre));
		Collections.sort(filteredByGenre, Comparator.comparing(Jeux::getJeux_Titre));
		if (!searchedJeux.isEmpty() && !filteredByGenre.isEmpty()) {
			searchedJeux.retainAll(filteredByGenre);
			model.addAttribute("jeux", searchedJeux);
		} else if (searchedJeux.isEmpty() && !filteredByGenre.isEmpty()) {
			model.addAttribute("jeux", filteredByGenre);
		} else {
			model.addAttribute("jeux", searchedJeux);
		}
		model.addAttribute("genre", genre);
		return "searchResult";
	}
	@GetMapping("/contact")
	public String viewContact(Model model){
		return "contact";
	}
	@GetMapping("/about")
	public String viewAbout(Model model){
		return"about";
	}	
}
