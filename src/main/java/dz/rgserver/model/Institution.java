package dz.rgserver.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="institution")
public class Institution implements Serializable  {	

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nom;
	private String raisonSociale;
	private String statutJuridique;
	private String natureEtabelissement;
	private String logoChemin;
	@Temporal (TemporalType.DATE)
	private Date dateCreation;
	private String categorie;
	private String type;
	private String secteurActivite;
	private String siteWeb;
	private String email;
	private String telFixe;
	private String telPortable;
	private String fax;
	private String typeImplicationApa;
	private String anneeImplicationApa;
	//private String butAcceeRG;
	private String infoAdditionnelles;
	
	//la relation entre intitution et user. 
	@OneToMany(mappedBy = "institution", orphanRemoval=true)
	@JsonIgnore
	private Collection<User> users;
	
	//relation entre instituion et RG.
	@OneToMany(mappedBy = "institution", orphanRemoval=true)
	@JsonIgnore
	private Collection<Rg> rg ;

	//GETTERS AND SETTERS

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
	public String getRaisonSociale() {
		return raisonSociale;
	}
	public void setRaisonSociale(String raisonSociale) {
		this.raisonSociale = raisonSociale;
	}
	public String getStatutJuridique() {
		return statutJuridique;
	}
	public void setStatutJuridique(String statutJuridique) {
		this.statutJuridique = statutJuridique;
	}
	public String getNatureEtabelissement() {
		return natureEtabelissement;
	}
	public void setNatureEtabelissement(String natureEtabelissement) {
		this.natureEtabelissement = natureEtabelissement;
	}
	public String getLogoChemin() {
		return logoChemin;
	}
	public void setLogoChemin(String logoChemin) {
		this.logoChemin = logoChemin;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
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
	public String getSecteurActivite() {
		return secteurActivite;
	}
	public void setSecteurActivite(String secteurActivite) {
		this.secteurActivite = secteurActivite;
	}
	public String getSiteWeb() {
		return siteWeb;
	}
	public void setSiteWeb(String siteWeb) {
		this.siteWeb = siteWeb;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelFixe() {
		return telFixe;
	}
	public void setTelFixe(String telFixe) {
		this.telFixe = telFixe;
	}
	public String getTelPortable() {
		return telPortable;
	}
	public void setTelPortable(String telPortable) {
		this.telPortable = telPortable;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getInfoAdditionnelles() {
		return infoAdditionnelles;
	}
	public void setInfoAdditionnelles(String infoAdditionnelles) {
		this.infoAdditionnelles = infoAdditionnelles;
	}
	public Collection<User> getUsers() {
		return users;
	}
	public void setUsers(Collection<User> users) {
		this.users = users;
	}
	public Collection<Rg> getRessource() {
		return rg;
	}
	public void setRessource(Collection<Rg> rg) {
		this.rg = rg;
	}
	public String getTypeImplicationApa() {
		return typeImplicationApa;
	}
	public void setTypeImplicationApa(String typeImplicationApa) {
		this.typeImplicationApa = typeImplicationApa;
	}
	public String getAnneeImplicationApa() {
		return anneeImplicationApa;
	}
	public void setAnneeImplicationApa(String anneeImplicationApa) {
		this.anneeImplicationApa = anneeImplicationApa;
	}
	
	//CONSTRUCTORS
	
	public Institution(String nom) {
		
		this.nom = nom;
		
	}

	public Institution(long id, String nom, String raisonSociale, String statutJuridique, String natureEtabelissement,
			String logoChemin, Date dateCreation, String categorie, String type, String secteurActivite, String siteWeb,
			String email, String telFixe, String telPortable, String fax, String typeImplicationApa,
			String anneeImplicationApa, String infoAdditionnelles, List<User> users,
			Collection<Rg> rg) {
		super();
		this.id = id;
		this.nom = nom;
		this.raisonSociale = raisonSociale;
		this.statutJuridique = statutJuridique;
		this.natureEtabelissement = natureEtabelissement;
		this.logoChemin = logoChemin;
		this.dateCreation = dateCreation;
		this.categorie = categorie;
		this.type = type;
		this.secteurActivite = secteurActivite;
		this.siteWeb = siteWeb;
		this.email = email;
		this.telFixe = telFixe;
		this.telPortable = telPortable;
		this.fax = fax;
		this.typeImplicationApa = typeImplicationApa;
		this.anneeImplicationApa = anneeImplicationApa;
		this.infoAdditionnelles = infoAdditionnelles;
		this.users = users;
		this.rg = rg;
	}
	
	public Institution(long id, String nom, String raisonSociale, String statutJuridique, String natureEtabelissement,
			String logoChemin, Date dateCreation, String categorie, String type, String secteurActivite, String siteWeb,
			String email, String telFixe, String telPortable, String fax, String typeImplicationApa,
			String anneeImplicationApa, String infoAdditionnelles,
			Collection<Rg> rg) {
		super();
		this.id = id;
		this.nom = nom;
		this.raisonSociale = raisonSociale;
		this.statutJuridique = statutJuridique;
		this.natureEtabelissement = natureEtabelissement;
		this.logoChemin = logoChemin;
		this.dateCreation = dateCreation;
		this.categorie = categorie;
		this.type = type;
		this.secteurActivite = secteurActivite;
		this.siteWeb = siteWeb;
		this.email = email;
		this.telFixe = telFixe;
		this.telPortable = telPortable;
		this.fax = fax;
		this.typeImplicationApa = typeImplicationApa;
		this.anneeImplicationApa = anneeImplicationApa;
		this.infoAdditionnelles = infoAdditionnelles;
		this.rg = rg;
	}
	
	public Institution() {
		super();
	}


}