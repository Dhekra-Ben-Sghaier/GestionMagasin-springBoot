package tn.esprit.services;

import java.util.List;
import tn.esprit.repository.CatergorieProduitRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.entities.CategorieProduit;
import tn.esprit.entities.Produit;
import tn.esprit.entities.Stock;
import tn.esprit.repository.ProduitRepository;
import tn.esprit.repository.StockRepository;

@Slf4j
@Service
public class ProduitServiceImpl implements IProduitService {

	@Autowired
	ProduitRepository produitRepository;
	
	@Autowired
	CatergorieProduitRepository categorieProduitRepository;
	 
	@Autowired
	StockRepository stockRepository;
	
	@Override
	public List<Produit> retriveProduit() {
		List<Produit> produits= (List<Produit>) produitRepository.findAll();
		for (Produit produit: produits) {
			log.info("Produit :" + produit);
		}
		return produits;
	}

	@Override
	public Produit retriveById(Long id) {
		Produit produit = produitRepository.findById(id).orElse(null);
		log.info("Produit :" + produit);
		return produit; 
	}

	@Override
	public Produit saveProduit(Produit p) {
		return produitRepository.save(p);
	}

	@Override
	public Produit updateProduit(Produit p) {
		return produitRepository.save(p);
	}

	@Override
	public void deleteProduit(Long id) {
		Produit p = produitRepository.findById(id).orElse(null);
		produitRepository.delete(p);
		
	}

	@Override
	public Produit addProduit(Produit p, Long idCategorieProduit, Long idStock) {
		CategorieProduit cp = categorieProduitRepository.findById(idCategorieProduit).orElse(null);
		Stock s = stockRepository.findById(idStock).orElse(null);
		p.setCategorieProduit(cp);
		p.setStock(s);
		
		
		return produitRepository.save(p);
	}

	@Override
	public void assignProduitToStock(Long idProduit, Long idStock) {
		Produit p = produitRepository.findById(idProduit).orElse(null);
		Stock s = stockRepository.findById(idStock).orElse(null);
		p.setStock(s);
		
		produitRepository.save(p);
		
	}

	



}
