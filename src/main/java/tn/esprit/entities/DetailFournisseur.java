package tn.esprit.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
public class DetailFournisseur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long idDetailFournisseur;
	
	@Temporal(TemporalType.DATE)
	Date dateDebutCollaboration;
	String adresse;
	String matricule;
	
	@OneToOne(mappedBy="detailFournisseur")
	private Fournisseur fournisseur;
	

}
