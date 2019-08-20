package dz.rgserver.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="taxonimies")
public class Taxonomie implements Serializable {

	public Taxonomie(String espece, String genre, String famille, String ordre, String classe) {
		super();
		this.espece = espece;
		this.genre = genre;
		this.famille = famille;
		this.ordre = ordre;
		this.classe = classe;
	}

	public long getId_taxonomie() {
		return id_taxonomie;
	}

	public void setId_taxonomie(long id_taxonomie) {
		this.id_taxonomie = id_taxonomie;
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

	private static final long serialVersionUID = -9172544093025197955L;

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id_taxonomie;
	private String espece;
	private String genre;
	private String famille;
	private String ordre; 
	private String classe;

	public Taxonomie() {
	}

}
