package tn.esprit.services;

import java.util.List;

import tn.esprit.entities.Produit;

public interface IProduitService {
	
	List<Produit> retriveProduit();
	Produit retriveById(Long id);
	Produit saveProduit (Produit p);
	
	Produit updateProduit (Produit p);
	
	void deleteProduit(Long id);
	Produit addProduit(Produit p, Long idCategorieProduit, Long idStock) ;
	void assignProduitToStock(Long idProduit, Long idStock);

}
