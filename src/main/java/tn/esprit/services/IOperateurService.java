package tn.esprit.services;

import java.util.List;

import tn.esprit.entities.Operateur;

public interface IOperateurService {
	
	List<Operateur> retriveOperateurs();
	Operateur retriveOperateurById(Long id);
	Operateur saveOperateur (Operateur o);
	
	Operateur updateOperateur (Operateur o);
	void deleteOperateur(Long id);
	void assignOperateurToFacture(Long idOperateur, Long idFacture);
}
