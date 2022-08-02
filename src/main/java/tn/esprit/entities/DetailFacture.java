package tn.esprit.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DetailFacture {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long idDetailFacture;
	Integer qteCommandee;
	float prixTotalDetail;
	Integer pourcentageRemise;
	float montantRemise;
	
	@ManyToOne(cascade = CascadeType.ALL)
	Facture facture;
	
	@ManyToOne(cascade = CascadeType.ALL)
	Produit produit;

}
