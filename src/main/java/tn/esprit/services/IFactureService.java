package tn.esprit.services;

import java.util.Date;
import java.util.List;

import tn.esprit.entities.Facture;
import tn.esprit.entities.Reglement;

public interface IFactureService {
	
	List<Facture> retrieveAllFactures();

	void cancelFacture(Long id);
	Facture saveFacture (Facture f);
	Facture retrieveFacture(Long id);
	Facture updateFacture (Facture f);
	void deleteFacture(Long id);
	List<Facture> getFacturesByFournisseur(Long idFournisseur);
	Facture addFacture(Facture f, Long idFournisseur);
	Reglement addReglement(Reglement r, Long idFacture);
	//float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate);
	//float pourcentageRecouvrement(Date startDate, Date endDate);
    void getSumFacture(Date startDate, Date endDate);       

}