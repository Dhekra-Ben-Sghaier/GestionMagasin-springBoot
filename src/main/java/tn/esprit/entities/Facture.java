package tn.esprit.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
public class Facture {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long idFacture;
	float montantRemise;
	float montantFacture;
	
	@Temporal(TemporalType.DATE)
	Date dateFacture;
	
	@Temporal(TemporalType.DATE)
	Date dateDerniereModification;
	boolean archivee;
	
	@ManyToOne
	Fournisseur fournisseur;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="facture")
	private Set<DetailFacture> detailFacture;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="facture")
	private Set<Reglement> reglement;
	
}
