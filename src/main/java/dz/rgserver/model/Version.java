package dz.rgserver.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Version implements Serializable{
	////####### Faire la relation entre les deux table
	
	@Id
	@GeneratedValue
	private long    id_version  ; //c'est l'id de classe version, on l'a nommé ainsi car on doit faire une join avec la classe RG (on doit avoir un champs en commun)
    
	private LocalDateTime date_version; //pour récuper la date de la modification
	private String type_action; // type_action : modification, suppression
	private Long idRessource; 
	
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
	
	/**************************   caracteristique RG PAR TYPE  ***************************/
	private String aliment;
	private String animale;
	private String marine;
	private String foret;
	private String micro;
	/***************************  *********  **************************************/
	private int numVersion;
	
	
	

  /* @ManyToOne
    @JoinColumn(name = "ressource_id", nullable = false) // ressource_id: le nom de la clé étrangère
    private RessourceGenetique ressourceGenetique;  //objet de type RG*/
   


	public Long getIdRessource() {
		return idRessource;
	}



	public void setIdRessource(Long idRessource) {
		this.idRessource = idRessource;
	}

	public Version () {
		super();
		
	}

	


	public long getId_version() {
		return id_version;
	}


	public String getType_action() {
		return type_action;
	}

	public void setType_action(String type_action) {
		this.type_action = type_action;
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



	public String getAliment() {
		return aliment;
	}



	public void setAliment(String aliment) {
		this.aliment = aliment;
	}



	public String getAnimale() {
		return animale;
	}



	public void setAnimale(String animale) {
		this.animale = animale;
	}



	public String getMarine() {
		return marine;
	}



	public void setMarine(String marine) {
		this.marine = marine;
	}



	public String getForet() {
		return foret;
	}



	public void setForet(String foret) {
		this.foret = foret;
	}



	public String getMicro() {
		return micro;
	}



	public void setMicro(String micro) {
		this.micro = micro;
	}



	public void setId_version(long id_version) {
		this.id_version = id_version;
	}
	public LocalDateTime getDate_version() {
		return date_version;
	}



	public void setDate_version() {
		//LocalDate localDate = LocalDate.now();
		LocalDateTime localDateTime = LocalDateTime.now();
		date_version = localDateTime;
	}



	public int getNumVersion() {
		return numVersion;
	}



	public void setNumVersion(int numVersion) {
		this.numVersion = numVersion;
	}
	
	




}
