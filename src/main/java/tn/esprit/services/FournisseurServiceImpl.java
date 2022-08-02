package tn.esprit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.entities.DetailFournisseur;
import tn.esprit.entities.Fournisseur;
import tn.esprit.repository.DetailsFournisseurRepository;
import tn.esprit.repository.FournisseurRepository;


@Slf4j
@Service
public class FournisseurServiceImpl implements IFournisseurService{

	
	@Autowired
	FournisseurRepository fournisseurRepository;
	
	@Autowired
	DetailsFournisseurRepository detailsFournisseurRerpository;
	
	
	@Override
	public List<Fournisseur> retriveFournisseurs() {
		List<Fournisseur> fournisseurs = (List<Fournisseur>) fournisseurRepository.findAll();
		
		for (Fournisseur fournisseur: fournisseurs) {
			log.info("fournisseur :" + fournisseur);
		}
		return fournisseurs;
	}

	@Override
	public Fournisseur retriveFournisseurById(Long id) {
		Fournisseur fournisseur = fournisseurRepository.findById(id).orElse(null);
		log.info("fournisseur :" + fournisseur);
		return fournisseur;
	}

	@Override
	public Fournisseur saveFournisseur(Fournisseur f) {
		DetailFournisseur df = addDetailFournisseur(f);
		
		f.setDetailFournisseur(df);
		return fournisseurRepository.save(f);
	}

	private DetailFournisseur addDetailFournisseur(Fournisseur f) {
		DetailFournisseur df = f.getDetailFournisseur();
		return detailsFournisseurRerpository.save(df );
	}

	@Override
	public Fournisseur updateFournisseur(Fournisseur f) {
		return fournisseurRepository.save(f);
	}

	@Override
	public void deleteFournisseur(Long id) {
		Fournisseur f = fournisseurRepository.findById(id).orElse(null);
		fournisseurRepository.delete(f);
		
	}
	
	

}
