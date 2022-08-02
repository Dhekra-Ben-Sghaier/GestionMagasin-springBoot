package tn.esprit.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reglement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long idReglement;
	float montantPaye;
	float montantRestant;
	boolean payee;
	@Temporal(TemporalType.DATE)
	Date dateReglement;
	
	@ManyToOne(cascade = CascadeType.ALL)
	Facture facture;
}
