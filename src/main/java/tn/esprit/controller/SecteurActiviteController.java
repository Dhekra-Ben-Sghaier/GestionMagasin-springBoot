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
import tn.esprit.entities.Fournisseur;
import tn.esprit.entities.SecteurActivite;
import tn.esprit.services.ISecteurActiviteService;



@RestController
@Api(tags = "secteurActivite management")
@RequestMapping("/secteurActivite")
public class SecteurActiviteController {
	@Autowired
	ISecteurActiviteService secteurActiviteService;
	
	
	@GetMapping("/afficherSecteursActivites")
	List<SecteurActivite> afficherSecteursActivites(){
		return secteurActiviteService.retriveSecteurActivite();
		
	}
	@GetMapping("/afficherSecteurActiviteById")
	@ResponseBody
	SecteurActivite afficherStock(@RequestParam Long idSecteurActivite) {
		return secteurActiviteService.retriveById(idSecteurActivite);
		
	}

	@PostMapping("/ajouterSecteurActivite")
	@ResponseBody
	SecteurActivite ajouterStock(@RequestBody SecteurActivite sa) {
		return secteurActiviteService.saveSecteurActivite(sa);
	}
	
	@PutMapping("/modifierSecteurActivite")
	@ResponseBody
	SecteurActivite modifierStock(@RequestBody SecteurActivite s) {
		return secteurActiviteService.updateSecteurActivite(s);
	}
	@DeleteMapping("/deleteSecteurActivite")
	@ResponseBody
	void supprimerSecteurActivite(@RequestParam Long idSecteurActivite) {
		secteurActiviteService.deleteSecteurActivite(idSecteurActivite);
		
	}

	@PutMapping("/assignSecteurActiviteToFournisseur")
	@ResponseBody
	public void assignSecteurActiviteToFournisseur(@RequestBody Long fournisseurId,@RequestBody Long
			secteurActiviteId) {
	
		secteurActiviteService.assignSecteurActiviteToFournisseur(fournisseurId, secteurActiviteId);
		
	}

}
