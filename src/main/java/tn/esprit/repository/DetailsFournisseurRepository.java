package tn.esprit.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.entities.DetailFournisseur;


@Repository
public interface DetailsFournisseurRepository extends CrudRepository<DetailFournisseur, Long>{

}
