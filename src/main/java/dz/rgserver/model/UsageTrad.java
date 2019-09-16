package dz.rgserver.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="usage_trad")

public class UsageTrad implements Serializable {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String description;
	private String recetteProduction;

	@ManyToOne
	private Rg rg;
	
	//GETTERS AND SETTERS

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRecetteProduction() {
		return recetteProduction;
	}

	public void setRecetteProduction(String recetteProduction) {
		this.recetteProduction = recetteProduction;
	}

	public Rg getRessource() {
		return rg;
	}

	public void setRessource(Rg rg) {
		this.rg = rg;
	}
	 
	

}
