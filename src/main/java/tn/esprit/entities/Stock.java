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
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@ToString
public class Stock {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long idStock;
	Integer qte;
	Integer qteMin;
	String libelleStock;
	 @JsonIgnore
	@OneToMany( mappedBy="stock")
	private Set<Produit> produit;
	
	
	

}
