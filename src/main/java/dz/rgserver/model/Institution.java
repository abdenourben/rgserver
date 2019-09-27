package dz.rgserver.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="institution")
public class Institution implements Serializable  {	

	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long   id;
	private String nom;
	private String raison;
	private String statut;
	private String logo;
	@Temporal (TemporalType.DATE)
	private @DateTimeFormat(pattern = "yyyy-mm-dd") Date   Creation;
	private String categorie;
	private String type;
	private String secteur;
	private String site;
	private String email;
	private String telephone;
	private String fax;
	private String adresse;
	private String typeApa;
	@Temporal (TemporalType.DATE)
	private @DateTimeFormat(pattern = "yyyy-mm-dd")Date anneeApa;
	private String infoAdd;
	
	//relation institution-file 
	@OneToMany
	@JsonIgnore
	private List<DBFile> files;
	
	
	//la relation entre intitution et user. 
	@OneToMany
	@JsonIgnore
	private List<User> users;
	//Relation image institution	
	@OneToOne
	@JsonIgnore
    private Image image;
	
	//relation entre instituion et RG.
	@OneToMany
	@JsonIgnore
	private List<Rg> rg ;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getRaison() {
		return raison;
	}
	public void setRaison(String raison) {
		this.raison = raison;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public Date getCreation() {
		return Creation;
	}
	public void setCreation(Date creation) {
		Creation = creation;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSecteur() {
		return secteur;
	}
	public void setSecteur(String secteur) {
		this.secteur = secteur;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTypeApa() {
		return typeApa;
	}
	public void setTypeApa(String typeApa) {
		this.typeApa = typeApa;
	}
	public Date getAnneeApa() {
		return anneeApa;
	}
	public void setAnneeApa(Date anneeApa) {
		this.anneeApa = anneeApa;
	}
	public String getInfoAdd() {
		return infoAdd;
	}
	public void setInfoAdd(String infoAdd) {
		this.infoAdd = infoAdd;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	public List<Rg> getRg() {
		return rg;
	}
	public void setRg(List<Rg> rg) {
		this.rg = rg;
	}
	public Institution() {
		super();
	}
	public Institution(String nom, String raison, String statut, String logo, Date creation, String categorie,
			String type, String secteur, String site, String email, String telephone, String fax, String adresse,
			String typeApa, Date anneeApa, String infoAdd) {
		super();
		this.nom = nom;
		this.raison = raison;
		this.statut = statut;
		this.logo = logo;
		Creation = creation;
		this.categorie = categorie;
		this.type = type;
		this.secteur = secteur;
		this.site = site;
		this.email = email;
		this.telephone = telephone;
		this.fax = fax;
		this.adresse = adresse;
		this.typeApa = typeApa;
		this.anneeApa = anneeApa;
		this.infoAdd = infoAdd;
	}
	
	
	
}