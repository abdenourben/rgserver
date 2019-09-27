package dz.rgserver.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="image")
public class Image implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String titre;
	private String description;
	private String chemin;
	private String type;
	
	
	public Image(String titre, String description, String chemin, String type) {
		super();
		this.titre = titre;
		this.description = description;
		this.chemin = chemin;
		this.type = type;
	}

	public Image() {
		super();
	}
	
	
	//relation image-RG
	@ManyToOne
	@JsonIgnore
	private Rg rg;
	 // relation avec activité 
	
	@OneToOne
	@JsonIgnore
	private Activite activite;
	
	// institution
	@OneToOne
	@JsonIgnore
	private Institution institution;
	
	public Institution getInstitution() {
		return institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	//GETTERS AND SETTERS
	
	public Rg getRg() {
		return rg;
	}

	public void setRg(Rg rg) {
		this.rg = rg;
	}

	public Activite getActivite() {
		return activite;
	}

	public void setActivite(Activite activite) {
		this.activite = activite;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getChemin() {
		return chemin;
	}

	public void setChemin(String chemin) {
		this.chemin = chemin;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Rg getRessource() {
		return rg;
	}

	public void setRessource(Rg rg) {
		this.rg = rg;
	}

}