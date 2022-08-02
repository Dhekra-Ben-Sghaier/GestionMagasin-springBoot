package tn.esprit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.entities.Fournisseur;
import tn.esprit.entities.SecteurActivite;
import tn.esprit.repository.FournisseurRepository;
import tn.esprit.repository.SecteurActiviteRepository;

@Slf4j
@Service
public class SecteurActiviteServiceImpl implements ISecteurActiviteService{

	@Autowired
	SecteurActiviteRepository secteurActiviteRepository;
	
	
	@Autowired
	FournisseurRepository fournisseurRepository;
	
	@Override
	public List<SecteurActivite> retriveSecteurActivite() {
		
		List<SecteurActivite> secteurActivites = (List<SecteurActivite>) secteurActiviteRepository.findAll();
		for (SecteurActivite secteurActivite: secteurActivites) {
			log.info("Factures :" + secteurActivite);
		}
		return secteurActivites;
	}

	@Override
	public SecteurActivite retriveById(Long id) {
		SecteurActivite secteurActivite = secteurActiviteRepository.findById(id).orElse(null);
		log.info("Factures :" + secteurActivite);
		return secteurActivite;
	}

	@Override
	public SecteurActivite saveSecteurActivite(SecteurActivite sa) {
		return secteurActiviteRepository.save(sa);
	}

	@Override
	public SecteurActivite updateSecteurActivite(SecteurActivite sa) {
		return secteurActiviteRepository.save(sa);
	}

	@Override
	public void deleteSecteurActivite(Long id) {
		SecteurActivite sa = secteurActiviteRepository.findById(id).orElse(null);
		secteurActiviteRepository.delete(sa);
		
		
	}
	@Override
	public void assignSecteurActiviteToFournisseur(Long fournisseurId, Long
			secteurActiviteId) {
		SecteurActivite secteurActivite =  secteurActiviteRepository.findById(secteurActiviteId).orElse(null);
		Fournisseur fournisseur= fournisseurRepository.findById(fournisseurId).orElse(null);
		//secteurActivite.getFournisseurs().add(fournisseur);
		fournisseur.getSecteurActivite().add(secteurActivite);
		fournisseurRepository.save(fournisseur);
	}

}
