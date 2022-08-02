package tn.esprit.repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import tn.esprit.entities.Facture;


@Repository
public interface FactureRepository extends JpaRepository<Facture,Long> {
	
	/*@Query("DELETE FROM Facture f WHERE f.idFacture= :idFacture AND f.active = FALSE")
	void deleteFacture(@Param("idFacture")Long idFacture);*/
	@Query("SELECT f FROM Facture f WHERE f.fournisseur= :Fournisseur")
	List<Facture> getFactureByFournisseur(@Param("Fournisseur")Long fournisseur);
	//List<Facture> findByDataCreationFactureBetween(Date d1 , Date d2);
	 @Query("select SUM(f.montantFacture-f.montantRemise) from  Facture f where f.dateFacture  between :startDate AND :endDate")
	    double getSum(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
	 
}