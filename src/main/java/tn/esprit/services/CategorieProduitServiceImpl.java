package tn.esprit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.entities.CategorieProduit;
import tn.esprit.repository.CatergorieProduitRepository;

@Slf4j
@Service
public class CategorieProduitServiceImpl implements ICategorieProduitService{

	@Autowired
	CatergorieProduitRepository categorieproduitRepository;
	
	@Override
	public List<CategorieProduit> retriveCategorieProduits() {
		List<CategorieProduit> categorieProduits = (List<CategorieProduit>) categorieproduitRepository.findAll();
		for(CategorieProduit categorieProduit : categorieProduits ) {
			log.info("Categorie Produit :"+categorieProduit);
		}
		return categorieProduits;
	}

	@Override
	public CategorieProduit retriveById(Long id) {

		CategorieProduit categorieProduit = categorieproduitRepository.findById(id).orElse(null);
		 log.info("Categorie Produit :"+categorieProduit);
		
		return categorieProduit;
	}

	@Override
	public CategorieProduit saveCategorieProduit(CategorieProduit cp) {
		return categorieproduitRepository.save(cp);
	}

	@Override
	public CategorieProduit updateCategorieProduit(CategorieProduit cp) {

		return categorieproduitRepository.save(cp);
	}

	@Override
	public void deleteCategorirProduit(Long id) {

		CategorieProduit cp = categorieproduitRepository.findById(id).orElse(null);
		categorieproduitRepository.delete(cp);
		
	}

}
