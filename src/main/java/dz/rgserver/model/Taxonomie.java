package dz.rgserver.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="taxonomie")
public class Taxonomie implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String espece;
	private String genre;
	private String famille;
	private String ordre; 
	private String classe;
	
	//relation Taxonomie-RG
	@OneToMany
	@JsonIgnore
	private List<Rg> rg;
	
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

	public List<Rg> getRessource() {
		return rg;
	}

	public void setRessource(List<Rg> rg) {
		this.rg = rg;
	}

	public List<Rg> getRg() {
		return rg;
	}

	public void setRg(List<Rg> rg) {
		this.rg = rg;
	}

	public Taxonomie() {
		super();
	}

	public Taxonomie(String espece, String genre, String famille, String ordre, String classe) {
		super();
		this.espece = espece;
		this.genre = genre;
		this.famille = famille;
		this.ordre = ordre;
		this.classe = classe;
	}
	
}