package com.crud.jeuxVideo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.crud.jeuxVideo.db.JeuxFactory;
import com.crud.jeuxVideo.model.Jeux;

@Controller
public class AppController {

    @GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("jeux",JeuxFactory.getJeux());
		return "index";
	}
    @GetMapping("/newJeux")
    public String newJeuxForm(Model model) {
		model.addAttribute("jeux", new Jeux());
		return "newJeux";
	}
	@PostMapping("/newJeux")
	public String newJeuxSubmit(@ModelAttribute Jeux jeux, Model model){
		// JeuxDB.insertJeux(jeux);
		model.addAttribute("newJeux", jeux);
		return "result";
	}
}
