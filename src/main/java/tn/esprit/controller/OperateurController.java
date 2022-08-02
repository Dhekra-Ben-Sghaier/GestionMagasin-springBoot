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
import tn.esprit.entities.Operateur;
import tn.esprit.services.IOperateurService;



@RestController
@Api(tags = "operateur management")
@RequestMapping("/operateur")
public class OperateurController {

	@Autowired
	IOperateurService operateurService;
	
	@GetMapping("/afficherOperateur")
	List<Operateur> afficherOperateurs(){
		return operateurService.retriveOperateurs();
		
	}
	@GetMapping("/afficherOperateurById")
	@ResponseBody
	Operateur afficherOperateur(@RequestParam Long idOperateur) {
		return operateurService.retriveOperateurById(idOperateur);
		
	}
	

	@PostMapping("/ajouterOperateur")
	@ResponseBody
	Operateur ajouterOperateur(@RequestBody Operateur p) {
		return operateurService.saveOperateur(p);
	}
	
	@PutMapping("/modifierOperateur")
	@ResponseBody
	Operateur modifierStock(@RequestBody Operateur p) {
		return operateurService.updateOperateur(p);
	}
	@DeleteMapping("/deleteOperateur")
	@ResponseBody
	void supprimerStock(@RequestParam Long idOperateur) {
		operateurService.deleteOperateur(idOperateur);
		
	}
	
	
}
