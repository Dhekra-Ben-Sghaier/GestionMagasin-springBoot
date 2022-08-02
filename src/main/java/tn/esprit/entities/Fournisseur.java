package tn.esprit.entities;



import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
public class Fournisseur{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long idFournisseur;
	String codeFournisseur;
	String libelleFournisseur;
	
	@Enumerated(EnumType.STRING)
	CategorieFournisseur categorieFournisseur;
	
	@ManyToMany(cascade = CascadeType.ALL)
	Set<SecteurActivite> secteurActivite;
	
	@OneToOne
	private DetailFournisseur detailFournisseur;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="fournisseur")
	private Set<Facture> facture;
	
	
}
