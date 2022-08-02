package tn.esprit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.entities.DetailFournisseur;
import tn.esprit.entities.Fournisseur;
import tn.esprit.repository.DetailsFournisseurRepository;


@Slf4j
@Service
public class DetailsFournisseurServiceImpl implements IDetailsFournisseurService{

	@Autowired
	DetailsFournisseurRepository detailsFournisseurRerpository;
	
	
	@Override
	public List<DetailFournisseur> retriveDetailsFournisseurs() {
	
		List<DetailFournisseur> detailsfournisseurs = (List<DetailFournisseur>)  detailsFournisseurRerpository.findAll();
		
		for (DetailFournisseur detailsFournisseur: detailsfournisseurs) {
			log.info("details fournisseur :" + detailsFournisseur);
		}
		return detailsfournisseurs;
	}

	@Override
	public DetailFournisseur retriveDetailsFournisseurById(Long id) {
		DetailFournisseur detailsFournisseur = detailsFournisseurRerpository.findById(id).orElse(null);
		log.info("detailsFournisseur :" + detailsFournisseur);
		return detailsFournisseur;
	}

	@Override
	public DetailFournisseur saveDetailsFournisseur(DetailFournisseur df) {
	
		 	return detailsFournisseurRerpository.save(df);
	}

	@Override
	public DetailFournisseur updateDetailsFournisseur(DetailFournisseur df) {
	 	return detailsFournisseurRerpository.save(df);
	}

	@Override
	public void deleteDetailsFournisseur(Long id) {
		DetailFournisseur df = detailsFournisseurRerpository.findById(id).orElse(null);
		detailsFournisseurRerpository.delete(df);
		
	}

}
