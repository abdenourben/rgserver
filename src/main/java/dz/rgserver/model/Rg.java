package dz.rgserver.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="rg")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Rg implements Serializable {

	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	protected long id; 
	protected String nomCommunFr;
	protected String nomCommunAr; 
	protected String nomScientifique;
	protected String description;
	protected String morphologie;
	protected String formuleChimique; 
	protected String environnement; 
	protected String cycleVie; 
	protected String etatRisque; 
	
	
	// relation entre RG-institution
	@ManyToOne
	@JsonIgnore
	private Institution institution;
	
	//relation RG-taxonmie
	@ManyToOne
	@JsonIgnore
	private Taxonomie taxonomie;

	//on to many
	
	//relation entre RG-user
	@OneToMany(mappedBy = "rg", orphanRemoval=true)
	@JsonIgnore
	private Collection<User> users;
	
	//relation RG-image
	@OneToMany(mappedBy = "rg", orphanRemoval=true)
	@JsonIgnore
	private Collection<Image> images;
	
	//relation RG-region ManyToMany
	@OneToMany(mappedBy = "rg", orphanRemoval=true)
	@JsonIgnore
	private Collection<Region> regions;
	
	//relation RG_usageCommercial
	@OneToMany(mappedBy = "rg", orphanRemoval=true)
	@JsonIgnore
	private Collection<UsageCom> usageCom;
	
	//relation RG_usageTraditionnel
	@OneToMany(mappedBy = "rg", orphanRemoval=true)
	@JsonIgnore
	private Collection<UsageTrad> usageTrad;
	
	
	//GETTERS AND SETTERS

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomScientifique() {
		return nomScientifique;
	}

	public void setNomScientifique(String nomScientifique) {
		this.nomScientifique = nomScientifique;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public String getMorphologie() {
		return morphologie;
	}

	public void setMorphologie(String morphologie) {
		this.morphologie = morphologie;
	}

	public String getFormuleChimique() {
		return formuleChimique;
	}

	public void setFormuleChimique(String formuleChimique) {
		this.formuleChimique = formuleChimique;
	}


	public String getEnvironnement() {
		return environnement;
	}

	public void setEnvironnement(String environnement) {
		this.environnement = environnement;
	}


	public String getCycleVie() {
		return cycleVie;
	}

	public void setCycleVie(String cycleVie) {
		this.cycleVie = cycleVie;
	}

	public Institution getInstitution() {
		return institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	public Taxonomie getTaxonomie() {
		return taxonomie;
	}

	public void setTaxonomie(Taxonomie taxonomie) {
		this.taxonomie = taxonomie;
	}

	public Collection<User> getUsers() {
		return users;
	}

	public void setUsers(Collection<User> users) {
		this.users = users;
	}

	public Collection<Image> getImages() {
		return images;
	}

	public void setImages(Collection<Image> images) {
		this.images = images;
	}

	public Collection<Region> getRegions() {
		return regions;
	}

	public void setRegions(Collection<Region> regions) {
		this.regions = regions;
	}

	public Collection<UsageCom> getUsageCom() {
		return usageCom;
	}

	public void setUsageCom(Collection<UsageCom> usageCom) {
		this.usageCom = usageCom;
	}

	public Collection<UsageTrad> getUsageTrad() {
		return usageTrad;
	}

	public void setUsageTrad(Collection<UsageTrad> usageTrad) {
		this.usageTrad = usageTrad;
	}
	
	public String getNomCommunFr() {
		return nomCommunFr;
	}

	public void setNomCommunFr(String nomCommunFr) {
		this.nomCommunFr = nomCommunFr;
	}

	public String getNomCommunAr() {
		return nomCommunAr;
	}

	public void setNomCommunAr(String nomCommunAr) {
		this.nomCommunAr = nomCommunAr;
	}
	
	public String getEtatRisque() {
		return etatRisque;
	}

	public void setEtatRisque(String etatRisque) {
		this.etatRisque = etatRisque;
	}
	
	//CONSTRUCTORS
	

	public Rg(String nomCommunFr, String nomCommunAr, String nomScientifique) {
		this.nomCommunAr = nomCommunAr; 
		this.nomCommunFr = nomCommunFr; 
		this.nomScientifique = nomScientifique;
	}

	public Rg(long id, String designationFr, String designationAr, String nomCommun,
			String nomScientifique, String description, String propriete, String morphologie, String formuleChimique,
			String structure, String environnement, String transmission, String cycleVie, String etatRisque, Institution institution,
			Taxonomie taxonomie, List<User> users, List<Image> images, List<Region> regions, List<UsageCom> usageCom,
			List<UsageTrad> usageTrad) {
		super();
		this.id = id;
		this.nomScientifique = nomScientifique;
		this.description = description;
		this.morphologie = morphologie;
		this.formuleChimique = formuleChimique;
		this.environnement = environnement;
		this.cycleVie = cycleVie;
		this.etatRisque = etatRisque; 
		this.institution = institution;
		this.taxonomie = taxonomie;
		this.users = users;
		this.images = images;
		this.regions = regions;
		this.usageCom = usageCom;
		this.usageTrad = usageTrad;
	}
	
	public Rg(long id, String designationFr, String designationAr, String nomCommun,
			String nomScientifique, String description, String propriete, String morphologie, String formuleChimique,
			String structure, String environnement, String transmission, String cycleVie, Institution institution, Taxonomie taxonomie
			) {
		super();
		this.id = id;
		this.nomScientifique = nomScientifique;
		this.description = description;
		this.morphologie = morphologie;
		this.formuleChimique = formuleChimique;
		this.environnement = environnement;
		this.cycleVie = cycleVie;
		this.institution = institution;
		this.taxonomie = taxonomie; 
	
	}
	
	
	public Rg(long id) {
		super();
		this.id = id;

	
	}

	public Rg() {
		super();
	}



	
}