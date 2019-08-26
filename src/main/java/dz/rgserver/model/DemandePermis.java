package dz.rgserver.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="demandesPermis")
public class DemandePermis implements Serializable{

	private static final long serialVersionUID = 1L;
   @Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id_demande;
	//si il s'agit d'une personne
	private String nomCompletBeneficiare;
	private String occupation; 
	//si il s'agit d'une entreprise
	private String nomEntreprise;
	private String numRegistreDeCommerce;
	//------------------------------------------
	private String adresse;
	private String adresseMail;
	private String etat; //de la demande, etapes du workflow
	private String categorie; //de la demande
	//-----------------------------------------------
	private String nomRessource;
	private String emplacementRessource;

	//private String typePermis;
	private String butUtilisationPermis;
	@Temporal( TemporalType.DATE) 
	private Date dateDebutAutorisation;
	private String dureeUtilisationPermis;
	//private Document documentIdentite;

//relation demande _user 
@OneToMany(mappedBy="demande",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
@JoinColumn(name="id_demande",referencedColumnName="user-id") 
private List<User> users;
  
	public String getNomCompletBeneficiare() {
		return nomCompletBeneficiare;
	}

	public void setNomCompletBeneficiare(String nomCompletBeneficiare) {
		this.nomCompletBeneficiare = nomCompletBeneficiare;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getNomEntreprise() {
		return nomEntreprise;
	}

	public void setNomEntreprise(String nomEntreprise) {
		this.nomEntreprise = nomEntreprise;
	}

	public String getNumRegistreDeCommerce() {
		return numRegistreDeCommerce;
	}

	public void setNumRegistreDeCommerce(String numRegistreDeCommerce) {
		this.numRegistreDeCommerce = numRegistreDeCommerce;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getAdresseMail() {
		return adresseMail;
	}

	public void setAdresseMail(String adresseMail) {
		this.adresseMail = adresseMail;
	}

	public String getNomRessource() {
		return nomRessource;
	}

	public void setNomRessource(String nomRessource) {
		this.nomRessource = nomRessource;
	}

	public String getEmplacementRessource() {
		return emplacementRessource;
	}

	public void setEmplacementRessource(String emplacementRessource) {
		this.emplacementRessource = emplacementRessource;
	}

	public String getButUtilisationPermis() {
		return butUtilisationPermis;
	}

	public void setButUtilisationPermis(String butUtilisationPermis) {
		this.butUtilisationPermis = butUtilisationPermis;
	}

	public Date getDateDebutAutorisation() {
		return dateDebutAutorisation;
	}

	public void setDateDebutAutorisation(Date dateDebutAutorisation) {
		this.dateDebutAutorisation = dateDebutAutorisation;
	}

	public String getDureeUtilisationPermis() {
		return dureeUtilisationPermis;
	}

	public void setDureeUtilisationPermis(String dureeUtilisationPermis) {
		this.dureeUtilisationPermis = dureeUtilisationPermis;
	}



	
	public DemandePermis(String etat, String categorie) {
		super();
		this.etat = etat;
		this.categorie = categorie;
	}
	

	public long getId_demande() {
		return id_demande;
	}

	public void setId_demande(long id_demande) {
		this.id_demande = id_demande;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	
	public DemandePermis() {
	}

}
