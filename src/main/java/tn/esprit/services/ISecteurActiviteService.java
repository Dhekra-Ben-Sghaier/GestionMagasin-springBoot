package tn.esprit.services;

import java.util.List;

import tn.esprit.entities.SecteurActivite;

public interface ISecteurActiviteService {
	List<SecteurActivite> retriveSecteurActivite();
	SecteurActivite retriveById(Long id);
	SecteurActivite saveSecteurActivite (SecteurActivite sa);
	
	SecteurActivite updateSecteurActivite (SecteurActivite sa);
	
	void deleteSecteurActivite(Long id);
	void assignSecteurActiviteToFournisseur(Long fournisseurId, Long
			secteurActiviteId);

}
