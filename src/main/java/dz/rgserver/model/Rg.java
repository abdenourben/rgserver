package dz.rgserver.model;

import java.io.Serializable;
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
	protected String structure;
	protected String environnement; 
	protected String transmission; 
	protected String cycleVie; 
	
	
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
	@OneToMany(mappedBy="rg",cascade=CascadeType.ALL)
	@JsonIgnore
	private List<User> users;
	
	//relation RG-image
	@OneToMany(mappedBy="rg",cascade=CascadeType.ALL)
	@JsonIgnore
	private List<Image> images;
	
	//relation RG-region 
	@OneToMany(mappedBy="rg",cascade=CascadeType.ALL)
	@JsonIgnore
	private List<Region> regions;
	
	//relation RG_usageCommercial
	@OneToMany(mappedBy="rg",cascade=CascadeType.ALL)
	@JsonIgnore
	private List<UsageCom> usageCom;
	
	//relation RG_usageTraditionnel
	@OneToMany(mappedBy="rg",cascade=CascadeType.ALL)
	@JsonIgnore
	private List<UsageTrad> usageTrad;
	
	
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

	public String getStructure() {
		return structure;
	}

	public void setStructure(String structure) {
		this.structure = structure;
	}

	public String getEnvironnement() {
		return environnement;
	}

	public void setEnvironnement(String environnement) {
		this.environnement = environnement;
	}

	public String getTransmission() {
		return transmission;
	}

	public void setTransmission(String transmission) {
		this.transmission = transmission;
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

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public List<Region> getRegions() {
		return regions;
	}

	public void setRegions(List<Region> regions) {
		this.regions = regions;
	}

	public List<UsageCom> getUsageCom() {
		return usageCom;
	}

	public void setUsageCom(List<UsageCom> usageCom) {
		this.usageCom = usageCom;
	}

	public List<UsageTrad> getUsageTrad() {
		return usageTrad;
	}

	public void setUsageTrad(List<UsageTrad> usageTrad) {
		this.usageTrad = usageTrad;
	}
	
	//CONSTRUCTORS

	public Rg(long id, String designationFr, String designationAr, String nomCommun,
			String nomScientifique, String description, String propriete, String morphologie, String formuleChimique,
			String structure, String environnement, String transmission, String cycleVie, Institution institution,
			Taxonomie taxonomie, List<User> users, List<Image> images, List<Region> regions, List<UsageCom> usageCom,
			List<UsageTrad> usageTrad) {
		super();
		this.id = id;
		this.nomScientifique = nomScientifique;
		this.description = description;
		this.morphologie = morphologie;
		this.formuleChimique = formuleChimique;
		this.structure = structure;
		this.environnement = environnement;
		this.transmission = transmission;
		this.cycleVie = cycleVie;
		this.institution = institution;
		this.taxonomie = taxonomie;
		this.users = users;
		this.images = images;
		this.regions = regions;
		this.usageCom = usageCom;
		this.usageTrad = usageTrad;
	}

	public Rg() {
		super();
	}
	
}