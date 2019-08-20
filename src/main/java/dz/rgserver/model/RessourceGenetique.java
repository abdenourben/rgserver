package dz.rgserver.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ressources")
public class RessourceGenetique implements Serializable {

	private static final long serialVersionUID = 5997137171945704628L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long    id_ressource      ;
	private String  designation_Fr    ;
	private String désignation_Ar;
	private String nom_commun;
	private String nom_scientifique;
	private String description;
	public long getId_ressource() {
		return id_ressource;
	}
	public void setId_ressource(long id_ressource) {
		this.id_ressource = id_ressource;
	}
	public String getDesignation_Fr() {
		return designation_Fr;
	}
	public void setDesignation_Fr(String designation_Fr) {
		this.designation_Fr = designation_Fr;
	}
	public String getDésignation_Ar() {
		return désignation_Ar;
	}
	public void setDésignation_Ar(String désignation_Ar) {
		this.désignation_Ar = désignation_Ar;
	}
	public String getNom_commun() {
		return nom_commun;
	}
	public void setNom_commun(String nom_commun) {
		this.nom_commun = nom_commun;
	}
	public String getNom_scientifique() {
		return nom_scientifique;
	}
	public void setNom_scientifique(String nom_scientifique) {
		this.nom_scientifique = nom_scientifique;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPropriété() {
		return propriété;
	}
	public void setPropriété(String propriété) {
		this.propriété = propriété;
	}
	public String getMorphologie() {
		return morphologie;
	}
	public void setMorphologie(String morphologie) {
		this.morphologie = morphologie;
	}
	public String getFormule_chemique() {
		return formule_chemique;
	}
	public void setFormule_chemique(String formule_chemique) {
		this.formule_chemique = formule_chemique;
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
	public String getCycle_vie() {
		return cycle_vie;
	}
	public void setCycle_vie(String cycle_vie) {
		this.cycle_vie = cycle_vie;
	}
	public RessourceGenetique(String designation_Fr, String désignation_Ar, String nom_commun, String nom_scientifique,
			String description, String propriété, String morphologie, String formule_chemique, String structure,
			String environnement, String transmission, String cycle_vie) {
		super();
		this.designation_Fr = designation_Fr;
		this.désignation_Ar = désignation_Ar;
		this.nom_commun = nom_commun;
		this.nom_scientifique = nom_scientifique;
		this.description = description;
		this.propriété = propriété;
		this.morphologie = morphologie;
		this.formule_chemique = formule_chemique;
		this.structure = structure;
		this.environnement = environnement;
		this.transmission = transmission;
		this.cycle_vie = cycle_vie;
	}
	public RessourceGenetique() {
		super();
	}
	private String propriété;
	private String morphologie;
	private String formule_chemique; 
	private String structure;
	private String environnement; 
	private String transmission; 
	private String cycle_vie; 
	
}
