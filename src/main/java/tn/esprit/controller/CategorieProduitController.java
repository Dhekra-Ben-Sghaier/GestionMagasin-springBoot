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
import tn.esprit.entities.CategorieProduit;
import tn.esprit.services.ICategorieProduitService;

@RestController
@Api(tags = "categorieProduit management")
@RequestMapping("/categorieProduit")
public class CategorieProduitController {
	
	@Autowired
	ICategorieProduitService categorieProduitService;
	
	@GetMapping("/afficherCategorieProduit")
	List<CategorieProduit> afficherCategorieProduits(){
		return categorieProduitService.retriveCategorieProduits();
		
	}
	@GetMapping("/afficherCategorieProduitById")
	@ResponseBody
	CategorieProduit afficherStock(@RequestParam Long idCategorieProduit) {
		return categorieProduitService.retriveById(idCategorieProduit);
		
	}
	

	@PostMapping("/ajouterCategorieProduit")
	@ResponseBody
	CategorieProduit ajouterCategorieProduit(@RequestBody CategorieProduit cp) {
		return categorieProduitService.saveCategorieProduit(cp);
	}
	
	@PutMapping("/modifierCategorieProduit")
	@ResponseBody
	CategorieProduit modifierCategorieProduit(@RequestBody CategorieProduit cp) {
		return categorieProduitService.updateCategorieProduit(cp);
	}
	
	@DeleteMapping("/deleteCategorieProduit")
	@ResponseBody
	void supprimerCategorieProduit(@RequestParam Long id) {
		categorieProduitService.deleteCategorirProduit(id);
		
	}

}
