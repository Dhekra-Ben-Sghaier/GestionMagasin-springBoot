package tn.esprit.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
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
import tn.esprit.entities.Facture;
import tn.esprit.entities.Reglement;
import tn.esprit.services.IFactureService;



@RestController
@Api(tags = "facture management")
@RequestMapping("/facture")
public class FactureController {
	@Autowired
	IFactureService factureService;
	
	@GetMapping("/afficherFacture")
	List<Facture> afficherFactures(){
		return factureService.retrieveAllFactures();
		
	}
	@GetMapping("/afficherFactureById")
	@ResponseBody
	Facture afficherStock(@RequestParam Long idFacture) {
		return factureService.retrieveFacture(idFacture);
		
	}
	

	@PostMapping("/ajouterFacture")
	@ResponseBody
	Facture ajouterFacture(@RequestBody Facture f) {
		return factureService.saveFacture(f);
	}
	
	@PutMapping("/modifierFacture")
	@ResponseBody
	Facture modifierFacture(@RequestBody Facture f) {
		return factureService.updateFacture(f);
	}
	
	@DeleteMapping("/deleteFacture")
	@ResponseBody
	void supprimerFacture(@RequestParam Long id) {
		factureService.deleteFacture(id);
		
	}
	
	
	
	@GetMapping("/afficherFactureByFournisseur")
	List<Facture> getFacturesFournisseur(Long idFournisseur){
		return factureService.getFacturesByFournisseur(idFournisseur);
		
	}
	
	@PostMapping("/addFacture")
	@ResponseBody
	Facture addFacture(@RequestBody Facture f,@RequestBody Long idFournisseur) {
		return factureService.addFacture(f, idFournisseur);
	}
	
	@PostMapping("/ajouterReglement")
	@ResponseBody
	Reglement addReglement(@RequestBody Reglement r,@RequestBody Long idFacture){
		return factureService.addReglement(r, idFacture);
	}
	
	/*@PostMapping("/getChiffreAffaireEntreDeuxDate")
	@ResponseBody
	float getChiffreAffaireEntreDeuxDate(@RequestBody Date startDate,@RequestBody Date endDate){
		return factureService.getChiffreAffaireEntreDeuxDate(startDate, endDate);
	}
	
	@PostMapping("/pourcentageRecouvrement")
	@ResponseBody
	float pourcentageRecouvrement(@RequestBody Date startDate,@RequestBody Date endDate){
	//@Scheduled(fixedRate = 10000)
		return factureService.pourcentageRecouvrement(startDate, endDate);
	}*/
	
	
    @GetMapping("/retrieve-ca")
    @ResponseBody
    public void getCA() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startdate = dateFormat.parse("2021-11-17");
        Date enddate = dateFormat.parse("2021-11-19");
        factureService.getSumFacture(startdate,enddate);
    }
}
