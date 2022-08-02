package tn.esprit.services;

import java.util.List;

import tn.esprit.entities.DetailFournisseur;

public interface IDetailsFournisseurService {
	
	List<DetailFournisseur> retriveDetailsFournisseurs();
	DetailFournisseur retriveDetailsFournisseurById(Long id);
	DetailFournisseur saveDetailsFournisseur (DetailFournisseur df);
	
	DetailFournisseur updateDetailsFournisseur (DetailFournisseur df);
	
	void deleteDetailsFournisseur(Long id);
}
