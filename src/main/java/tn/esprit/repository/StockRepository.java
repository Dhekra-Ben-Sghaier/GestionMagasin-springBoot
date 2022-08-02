package tn.esprit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.Stock;


@Repository
public interface StockRepository extends JpaRepository<Stock, Long>{
	
	
	
	// JPQL ou bien ("Select * from Stock s where s.libelleStock :?1") pour dire que c'est 
	@Query("select s from Stock s where s.libelleStock =: lib")
    List<Stock> retriveStockByLibelle(@Param("lib") String libelle);
	//il faut indiquer le nom du tab dans bd et non pas le nom du classe 
	@Query(value="select * from Stock s where s.libelleStock =?1", nativeQuery=true)
	List<Stock> retriveStockByLib(String libelle);
	
}
