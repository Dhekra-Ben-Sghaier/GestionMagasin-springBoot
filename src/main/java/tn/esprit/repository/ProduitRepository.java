package tn.esprit.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.entities.Produit;

public interface ProduitRepository extends CrudRepository<Produit, Long>{
	
	


	@Query(value = "INSERT INTO Produit (code, libelle,,PrixUnitaire,idstock) VALUES (:code,:libelle, :PrixUnitaire, :idstock)",
	nativeQuery = true)
	public Produit addProduit(@Param("code") String code, @Param("libelle") String libelle,
			@Param("PrixUnitaire") float PrixUnitaire, 
			@Param("idstock") Long idstock);
	
	

}
