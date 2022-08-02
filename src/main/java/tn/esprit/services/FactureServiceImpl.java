package tn.esprit.services;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.entities.CategorieProduit;
import tn.esprit.entities.DetailFacture;
import tn.esprit.entities.Facture;
import tn.esprit.entities.Fournisseur;
import tn.esprit.entities.Produit;
import tn.esprit.entities.Reglement;
import tn.esprit.entities.Stock;
import tn.esprit.repository.FactureRepository;
import tn.esprit.repository.FournisseurRepository;

@Slf4j
@Service
public class FactureServiceImpl implements IFactureService{
	@Autowired
	FactureRepository factureRepository;
	
	@Autowired
	FournisseurRepository fournisseurRepository;
	
	@Override
	public List<Facture> retrieveAllFactures() {
		
		List<Facture> factures=(List<Facture>) factureRepository.findAll();
		for (Facture facture: factures) {
			
			log.info("Factures :" + facture);
		}
		
		return factures;
	}

	@Override
	public void cancelFacture(Long id) {
		factureRepository.deleteById(id);
		
	}

	@Override
	public Facture retrieveFacture(Long id) {
		Facture facture = factureRepository.findById(id).get();
		log.info("Facture :" + facture);
		return facture;
	
	}

	@Override
	public Facture saveFacture(Facture f) {
		// TODO Auto-generated method stub
		return factureRepository.save(f);
	}

	@Override
	public Facture updateFacture(Facture f) {
		// TODO Auto-generated method stub
		return factureRepository.save(f);
	}

	@Override
	public void deleteFacture(Long id) {
		Facture f = factureRepository.findById(id).orElse(null);
		factureRepository.delete(f);
		
	}

	@Override
	public List<Facture> getFacturesByFournisseur(Long idFournisseur) {
		return factureRepository.getFactureByFournisseur(idFournisseur);
	
	
	}
	
	

	@Override
	public Facture addFacture(Facture f, Long idFournisseur) {
		Set<DetailFacture> df=f.getDetailFacture();
		float montantRemise=0f;
		float montantFacture=0f;
		for (DetailFacture detailFacture : df) {
			Produit p=detailFacture.getProduit();
			detailFacture.setPrixTotalDetail(p.getPrix()*detailFacture.getQteCommandee());
			detailFacture.setMontantRemise(detailFacture.getPrixTotalDetail()*detailFacture.getPourcentageRemise()/100);
			montantFacture+=detailFacture.getPrixTotalDetail();
			montantRemise+=detailFacture.getMontantRemise();
		}
		f.setMontantFacture(montantFacture);
		f.setMontantRemise(montantRemise);
		Fournisseur four=fournisseurRepository.findById(idFournisseur).orElse(null);
		four.getFacture().add(f);
		fournisseurRepository.save(four);
		return f;
	}


	/*@Override
	public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate) {
		Set<Facture> f= (Set<Facture>) factureRepository.findByDataCreationFactureBetween(startDate,endDate);
		float chAff=0f;
		for (Facture facture : f) {
			if (!facture.isArchivee()) {
				for (Reglement reglement : facture.getReglement()) {
					chAff+=reglement.getMontantPaye();
				}
			}
		}
		return chAff;
	}

	@Override
	public float pourcentageRecouvrement(Date startDate, Date endDate) {
		Set<Facture> f= (Set<Facture>) factureRepository.findByDataCreationFactureBetween(startDate,endDate);
		int s=0;
		int nbf=0;
		
		for (Facture facture : f) {
			if (!facture.isArchivee()) {
				nbf++;
				s+=facture.getReglement().size();
				
			}
		}
		return (float)s/nbf;
	}*/

	@Override
	public Reglement addReglement(Reglement r, Long idFacture) {
		Facture f=factureRepository.findById(idFacture).orElse(null);
		Set<Reglement> rs=f.getReglement();
		float smp=0f;
		for (Reglement reglement : rs) {
			smp+=reglement.getMontantPaye();
		}
		if((smp+r.getMontantPaye())<f.getMontantFacture()){
			r.setMontantPaye(smp+r.getMontantPaye());
			r.setMontantRestant(f.getMontantFacture()-(r.getMontantPaye()+smp));
			f.getReglement().add(r);
		}else if((smp+r.getMontantPaye())==f.getMontantFacture()){
			r.setMontantPaye(f.getMontantFacture());
			r.setMontantRestant(0f);
			r.setPayee(true);
			f.getReglement().add(r);
		}
		return r;
	}

	@Override
	public void getSumFacture(Date startDate, Date endDate) {
		double CA= factureRepository.getSum(startDate,endDate);
        String msg="le Chiffre d'affaire est : "+CA;
        System.out.print("le Chiffre d'affaire est : "+CA);
        log.info(msg);
		
	}
	
	
	

	
	

}
