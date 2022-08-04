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

import com.crud.jeuxVideo.model.Jeux;
import com.crud.jeuxVideo.model.JeuxRepository;

@Controller
public class AppController {

	@Autowired
	private JeuxRepository jeuxRepository;

    @GetMapping("/")
	public String viewHomePage(Model model) {
		ArrayList<Jeux> jeux = (ArrayList<Jeux>) jeuxRepository.findAll();
		Collections.sort(jeux, Comparator.comparing(Jeux::getJeux_Titre));
		model.addAttribute("jeux", jeux);
		return "index";
	}
	@GetMapping("/search")
	public String searchJeux(@RequestParam(name = "q")String searchText, Model model){
		List<Jeux> searchedJeux = jeuxRepository.searchJeux(searchText);
		Collections.sort(searchedJeux, Comparator.comparing(Jeux::getJeux_Titre));
		model.addAttribute("jeux", searchedJeux);
		return "searchResult";
	}		
}
