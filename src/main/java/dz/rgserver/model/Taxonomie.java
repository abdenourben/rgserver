package dz.rgserver.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="taxonomie")
public class Taxonomie implements Serializable {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String espece;
	private String genre;
	private String famille;
	private String ordre; 
	private String classe;
	
	//relation Taxonomie-RG
	@OneToMany(mappedBy = "taxonomie", orphanRemoval=true)
	@JsonIgnore
	private Collection<Rg> rg;
	
	//GETTERS AND SETTERS

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEspece() {
		return espece;
	}

	public void setEspece(String espece) {
		this.espece = espece;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getFamille() {
		return famille;
	}

	public void setFamille(String famille) {
		this.famille = famille;
	}

	public String getOrdre() {
		return ordre;
	}

	public void setOrdre(String ordre) {
		this.ordre = ordre;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public Collection<Rg> getRessource() {
		return rg;
	}

	public void setRessource(Collection<Rg> rg) {
		this.rg = rg;
	}
	
	//CONSTRUCTORS

	public Taxonomie(long id, String espece, String genre, String famille, String ordre, String classe,
			Collection<Rg> rg) {
		super();
		this.id = id;
		this.espece = espece;
		this.genre = genre;
		this.famille = famille;
		this.ordre = ordre;
		this.classe = classe;
		this.rg = rg;
	}

	public Taxonomie() {
		super();
	}
	
	
	
	
	

}