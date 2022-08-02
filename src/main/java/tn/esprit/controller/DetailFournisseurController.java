package tn.esprit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.entities.DetailFournisseur;
import tn.esprit.services.IDetailsFournisseurService;

@RestController 
@RequestMapping("detailfournisseurcontroller") 
public class DetailFournisseurController {
	@Autowired
	IDetailsFournisseurService detailFournisseurService;
	
	@GetMapping("/afficherDetailFournisseurs")
	@ResponseBody 
	List<DetailFournisseur> afficherDetailFournisseurs(){
	return detailFournisseurService.retriveDetailsFournisseurs();
	}
	
	
	@GetMapping("/afficherDetailFournisseur/{id}")
	@ResponseBody 
	DetailFournisseur afficherstock(@PathVariable("id")Long iddf) {
	return detailFournisseurService.retriveDetailsFournisseurById(iddf);
	}
	
	
	@PostMapping("/ajouterDetailFournisseur")
	@ResponseBody
	DetailFournisseur ajouterStock(@RequestBody DetailFournisseur df) {
	return detailFournisseurService.saveDetailsFournisseur(df);
	}
	
	@PutMapping("/updateDetailFournisseur")
	@ResponseBody
	DetailFournisseur updateDetailFournisseur(@RequestBody DetailFournisseur df) { 
	return detailFournisseurService.updateDetailsFournisseur(df);
	}
	
	@DeleteMapping("/deleteDetailFournisseur/{id}")
	@ResponseBody
	void deleteDetailFournisseur(@PathVariable("id") Long id) {
		detailFournisseurService.deleteDetailsFournisseur(id);
	}

}
