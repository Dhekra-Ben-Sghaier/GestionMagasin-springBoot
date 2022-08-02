package tn.esprit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import tn.esprit.entities.Produit;
import tn.esprit.services.IProduitService;


@RestController
@Api(tags = "produit management")
@RequestMapping("/produit")
public class ProduitController {

	
	@Autowired
	IProduitService produitService;
	
	@GetMapping("/afficherProduit")
	List<Produit> afficherProduits(){
		return produitService.retriveProduit();
		
	}
	
	@GetMapping("/afficherProduitById")
	@ResponseBody
	Produit afficherProduit(@RequestParam Long idProduit) {
		return produitService.retriveById(idProduit);
	}
	
	@PostMapping("/ajouterProduit")
	@ResponseBody
	Produit ajouterProduit(@RequestBody Produit p) {
		return produitService.saveProduit(p);
	}
	
	@PutMapping("/modifierProduit")
	@ResponseBody
	Produit modifierProduit(@RequestBody Produit p) {
		return produitService.updateProduit(p);
	}
	@DeleteMapping("/deleteProduit")
	@ResponseBody
	void supprimerStock(@RequestParam Long idProduit) {
		produitService.deleteProduit(idProduit);
		
	}
	
	@PutMapping("/assignProduitToStock")
	@ResponseBody
	public void assignProduitToStock(@RequestParam Long idProduit,@RequestParam Long idStock) {
		produitService.assignProduitToStock(idProduit, idStock);
	}

	
}
