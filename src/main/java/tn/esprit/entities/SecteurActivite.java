package tn.esprit.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class SecteurActivite {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long idFournisseur; 
	
	String codeSecteurActivite;
	String libelleSecteurActivite;
	
	@ManyToMany(mappedBy="secteurActivite", cascade = CascadeType.ALL)
	private Set<Fournisseur> fournisseurs;

}
