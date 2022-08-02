package tn.esprit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import tn.esprit.entities.Fournisseur;
import tn.esprit.services.IFournisseurService;



@RestController
@Api(tags = "fournisseur management")
@RequestMapping("/fournisseur")
public class FournisseurController {

	@Autowired
	IFournisseurService fournisseurService;
	
	@GetMapping("/afficherFournisseur")
	List<Fournisseur> afficherFournisseurs(){
		return fournisseurService.retriveFournisseurs();
		
	}
	@GetMapping("/afficherFournisseur/{id}")
	@ResponseBody
	Fournisseur afficherFournisseur(Long idFournisseur) {
		return fournisseurService.retriveFournisseurById(idFournisseur);
		
	}
	
	/*@GetMapping("/afficherFournisseur")
	@ResponseBody
	Fournisseur afficherFournisseur2(@RequestParam Long idFournisseur) {
		return fournisseurService.retriveFournisseurById(idFournisseur);
		
	}*/
	@PostMapping("/ajouterFournisseur")
	@ResponseBody
	Fournisseur ajouterFournisseur(@RequestBody Fournisseur p) {
		return fournisseurService.saveFournisseur(p);
	}
	
	@PutMapping("/ajouterFournisseur")
	@ResponseBody
	Fournisseur modifierStock(@RequestBody Fournisseur p) {
		return fournisseurService.updateFournisseur(p);
	}
	@DeleteMapping("/deleteFournisseur/{id}")
	@ResponseBody
	void supprimerStock(Long idFournisseur) {
		fournisseurService.deleteFournisseur(idFournisseur);
		
	}
	
	
}
