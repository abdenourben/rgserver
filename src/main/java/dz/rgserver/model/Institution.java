package dz.rgserver.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="institutions")
public class Institution implements Serializable  {
	
	// #1
	//Definitions des attributs d'une institution
	
	private static final long serialVersionUID = -4777034353580853974L;

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long    id_institution      ;
	private String  nom                 ;
	private String  resonSociale        ;
	private String  statuJuridique      ;
	private String  natureEtabelissement;
	private String  logoChemin          ;
	@Temporal (TemporalType.DATE)
	private Date    dateCreation        ;
	private String  categorie           ;
	private String  type                ;
	private String  secteurActivite     ;
	private String  siteWeb             ;
	private String  email               ;
	private String  telephoneFixe       ;
	private String  telephonePortable   ;
	private String  fax                 ;
	//private String typeImplicationApa ; 
	//private String anneeImplicationApa;
	//private String butAcceeRG         ;
	//private String classeRG           ;
	//private String informationAdditionnelles;
	
	
	// #2
	//Definition des relations
	
	@ManyToOne
	@JoinColumn(name="id_ressource")
	private RessourceGenetique ressourceGenetique;
	
	// #3
	//Definition des setters et getters
	
	
	public long getId() {
		return id_institution;
	}
	public Institution(String nom, String resonSociale, String statuJuridique, String natureEtabelissement,
			String logoChemin, Date dateCreation, String categorie, String type, String secteurActivite, String siteWeb,
			String email, String telephoneFixe, String telephonePortable, String fax) {
		super();
		this.nom = nom;
		this.resonSociale = resonSociale;
		this.statuJuridique = statuJuridique;
		this.natureEtabelissement = natureEtabelissement;
		this.logoChemin = logoChemin;
		this.dateCreation = dateCreation;
		this.categorie = categorie;
		this.type = type;
		this.secteurActivite = secteurActivite;
		this.siteWeb = siteWeb;
		this.email = email;
		this.telephoneFixe = telephoneFixe;
		this.telephonePortable = telephonePortable;
		this.fax = fax;
	}
	public Institution() {
		super();
		
	}
	public void setId(long id) {
		this.id_institution = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getResonSociale() {
		return resonSociale;
	}
	public void setResonSociale(String resonSociale) {
		this.resonSociale = resonSociale;
	}
	public String getStatuJuridique() {
		return statuJuridique;
	}
	public void setStatuJuridique(String statuJuridique) {
		this.statuJuridique = statuJuridique;
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
	public String getTelephoneFixe() {
		return telephoneFixe;
	}
	public void setTelephoneFixe(String telephoneFixe) {
		this.telephoneFixe = telephoneFixe;
	}
	public String getTelephonePortable() {
		return telephonePortable;
	}
	public void setTelephonePortable(String telephonePortable) {
		this.telephonePortable = telephonePortable;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	
}
