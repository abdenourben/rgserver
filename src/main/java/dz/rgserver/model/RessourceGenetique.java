package dz.rgserver.model;
import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ressources")
public class RessourceGenetique implements Serializable {

private static final long serialVersionUID = 5997137171945704628L;

@Id @GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="id_ressource")
private long    id_ressource      ;
private String  designation_Fr    ;
private String désignation_Ar;
private String nom_commun;
private String nom_scientifique;
private String description;
private String propriété;
private String morphologie;
private String formule_chemique; 
private String structure;
private String environnement; 
private String transmission; 
private String cycle_vie;
public long getId_ressource() {
return id_ressource;
}
//relation entre RG-user
@OneToMany(mappedBy="ressource",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
@JoinColumn(name="id_ressource",referencedColumnName="user_id")
private List<User> users;


//relation RG-taxonmie
@OneToOne(mappedBy="ressource",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
@JoinColumn(name="id_ressource",referencedColumnName="id_taxonomie")
private Taxonomie taxinomie;

//relation RG-classification 
@OneToOne(mappedBy="ressource",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
@JoinColumn(name="id_ressource",referencedColumnName="id_classification")
private Classification classification;

//relation RG-image
@OneToMany(mappedBy="ressource",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
@JoinColumn(name="id_ressource",referencedColumnName="id_image")
private List<Image> images;

//relation RG-region 
@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "RG_Region", joinColumns = @JoinColumn(name = "id_ressource", referencedColumnName = "id_ressource "), 
    inverseJoinColumns = @JoinColumn(name = "id_region ", referencedColumnName = "id_region "))
    private List<Region> regions;

//relation RG_Institution
@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "RG_Institution", joinColumns = @JoinColumn(name = "id_ressource", referencedColumnName = "id_ressource "), 
    inverseJoinColumns = @JoinColumn(name = "id_institution  ", referencedColumnName = "id_institution  "))
    private List<Institution> institutions;


//relation RG_usageCommercial
@OneToMany(mappedBy="ressource",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
@JoinColumn(name="id_ressource",referencedColumnName="id_use_commercile")
private List<UtilisationCommerciale> usage_com;

//relation RG_usageTraditionnel
@OneToMany(mappedBy="ressource",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
@JoinColumn(name="id_ressource",referencedColumnName="iid_use_trad")
private List<UtilisationTraditionnelle> usage_trad;


public List<UtilisationCommerciale> getUsage_com() {
return usage_com;
}
public void setUsage_com(List<UtilisationCommerciale> usage_com) {
this.usage_com = usage_com;
}
public List<UtilisationTraditionnelle> getUsage_trad() {
return usage_trad;
}
public void setUsage_trad(List<UtilisationTraditionnelle> usage_trad) {
this.usage_trad = usage_trad;
}

public List<Region> getRegions() {
return regions;
}
public void setRegions(List<Region> regions) {
this.regions = regions;
}

public List<Institution> getInstitutions() {
return institutions;
}
public void setInstitutions(List<Institution> institutions) {
this.institutions = institutions;
}
public Taxonomie getTaxinomie() {
return taxinomie;
}
public void setTaxinomie(Taxonomie taxinomie) {
this.taxinomie = taxinomie;
}
public Classification getClassification() {
return classification;
}
public void setClassification(Classification classification) {
this.classification = classification;
}
public List<Image> getImages() {
return images;
}
public void setImages(List<Image> images) {
this.images = images;
}
public List<User> getUsers() {
return users;
}
public void setUsers(List<User> users) {
this.users = users;
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

}
