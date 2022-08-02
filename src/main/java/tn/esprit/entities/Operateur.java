package tn.esprit.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
public class Operateur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long idOperateur;
	String nom;
	String prenom;
	String password;
	
	@OneToMany(cascade = CascadeType.ALL)
	Set<Facture> facture;

}
