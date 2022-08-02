package tn.esprit.services;

import java.util.List;

import tn.esprit.entities.Fournisseur;

public interface IFournisseurService {
	
	List<Fournisseur> retriveFournisseurs();
	Fournisseur retriveFournisseurById(Long id);
	Fournisseur saveFournisseur (Fournisseur f);
	
	Fournisseur updateFournisseur (Fournisseur f);
	
	void deleteFournisseur(Long id);

	

}