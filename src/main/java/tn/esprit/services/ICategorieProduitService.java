package tn.esprit.services;

import java.util.List;

import tn.esprit.entities.CategorieProduit;


public interface ICategorieProduitService {
	
	List<CategorieProduit> retriveCategorieProduits();
	CategorieProduit retriveById(Long id);
	CategorieProduit saveCategorieProduit (CategorieProduit cp);
	
	CategorieProduit updateCategorieProduit (CategorieProduit cp);
	
	void deleteCategorirProduit(Long id);

}
