package tn.esprit.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CategorieProduit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long idCategorieProduit;
	String codeProduit;
	String libelleCategorieProduit;
	
	 @JsonIgnore
	@OneToMany( mappedBy="categorieProduit")
	private Set<Produit> produit;

}
