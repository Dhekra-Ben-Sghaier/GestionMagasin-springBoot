package tn.esprit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.entities.Operateur;
import tn.esprit.repository.FactureRepository;
import tn.esprit.repository.OperateurRepository;

@Slf4j
@Service
public class OperateurServiceImpl implements IOperateurService {

	@Autowired
	OperateurRepository operateurRepository;
	
	@Autowired
	FactureRepository factureRepository;
	@Override
	public List<Operateur> retriveOperateurs() {
		List<Operateur> operateurs = (List<Operateur>) operateurRepository.findAll();
		for (Operateur operateur: operateurs) {
			log.info("Operateur :" + operateur);
		}
		return operateurs;
	}

	@Override
	public Operateur retriveOperateurById(Long id) {
		Operateur operateur = operateurRepository.findById(id).orElse(null);
		log.info("Operateur :" + operateur);
		return operateur;
	}

	@Override
	public Operateur saveOperateur(Operateur o) {
		return operateurRepository.save(o);
	}

	@Override
	public Operateur updateOperateur(Operateur o) {
		return operateurRepository.save(o);
	}

	@Override
	public void deleteOperateur(Long id) {
	Operateur o = operateurRepository.findById(id).orElse(null);
	operateurRepository.delete(o);
		
	}

	@Override
	public void assignOperateurToFacture(Long idOperateur, Long idFacture) {
		Operateur op = operateurRepository.findById(idOperateur).orElse(null);
		op.getFacture().add(factureRepository.findById(idFacture).orElse(null));
		operateurRepository.save(op);
		
	}

}
