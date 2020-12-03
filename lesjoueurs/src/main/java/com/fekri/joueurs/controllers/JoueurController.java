package com.fekri.joueurs.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.fekri.joueurs.entities.Joueur;
import com.fekri.joueurs.service.JoueurService;

@Controller
public class JoueurController {
	@Autowired
	JoueurService joueurService;
	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap)
	{
		modelMap.addAttribute("joueur", new Joueur());
		modelMap.addAttribute("mode", "new");
		return "formJoueur";
	}
	@RequestMapping("/saveJoueur")
	public String saveJoueur(@Valid Joueur joueur,
			 					BindingResult bindingResult)
			{
			if (bindingResult.hasErrors()) return "formJoueur";

			joueurService.saveJoueur(joueur);
			return "formJoueur";
			}

	@RequestMapping("/ListeJoueur")
	public String ListeJoueur(ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size)
	{
		Page<Joueur> joues = joueurService.getAllJoueursParPage(page, size);
		modelMap.addAttribute("joueurs", joues);
		 modelMap.addAttribute("pages", new int[joues.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "ListeJoueur";

}
	@RequestMapping("/supprimerJoueur")
	public String supprimerJoueur(@RequestParam("id") Long id,
	 ModelMap modelMap,
				 @RequestParam (name="page",defaultValue = "0") int page,
				 @RequestParam (name="size", defaultValue = "2") int size)
	{
		joueurService.deleteJoueurById(id);
		Page<Joueur> joues = joueurService.getAllJoueursParPage(page,
				size);
				modelMap.addAttribute("joueurs", joues);
				modelMap.addAttribute("pages", new int[joues.getTotalPages()]);
				modelMap.addAttribute("currentPage", page);
				modelMap.addAttribute("size", size);
				return "ListeJoueur";

	}
	@RequestMapping("/modifierJoueur")
	public String updateJoueur(@RequestParam("id") Long id,ModelMap modelMap)
	{
	Joueur p= joueurService.getJoueur(id);
	modelMap.addAttribute("joueur", p);
	modelMap.addAttribute("mode", "edit");

	return "formJoueur";
	}
	@RequestMapping("/updateJoueur")
	public String updateJoueur(@ModelAttribute("joueur") Joueur joueur,
	@RequestParam("date") String date, ModelMap modelMap) throws ParseException 

	{
		 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		 Date jourdesignature = dateformat.parse(String.valueOf(date));
		 joueur.setjourdesignature(jourdesignature);

		 joueurService.updateJoueur(joueur);
		 List<Joueur> joues = joueurService.getAlljoueurs();
		  modelMap.addAttribute("joueurs", joues);
		return "ListeJoueur";
		}
	}
	
	
	
	
	




	