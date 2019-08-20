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
@Table(name="activites")
public class Activite implements Serializable {

	private static final long serialVersionUID = 4112122765227527191L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id_activite;
	private String titre;
	@Temporal (TemporalType.DATE)
	private Date date_debut;
	@Temporal (TemporalType.DATE)
	private Date date_fin;
	private String domaine;
	private String description;
	private String contenu; //resume, text
	private String pieces_activites; //images; videos
	private String type; // projet, event
	private String localisation; //address of event

	
	
	public Activite() {

	}



	public long getId_activite() {
		return id_activite;
	}



	public void setId_activite(long id_activite) {
		this.id_activite = id_activite;
	}



	public String getTitre() {
		return titre;
	}



	public void setTitre(String titre) {
		this.titre = titre;
	}



	public Date getDate_debut() {
		return date_debut;
	}



	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}



	public Date getDate_fin() {
		return date_fin;
	}



	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}



	public String getDomaine() {
		return domaine;
	}



	public void setDomaine(String domaine) {
		this.domaine = domaine;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getContenu() {
		return contenu;
	}



	public void setContenu(String contenu) {
		this.contenu = contenu;
	}



	public String getPieces_activites() {
		return pieces_activites;
	}



	public void setPieces_activites(String pieces_activites) {
		this.pieces_activites = pieces_activites;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getLocalisation() {
		return localisation;
	}



	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}



	public Activite(String titre, Date date_debut, Date date_fin, String domaine, String description, String contenu,
			String pieces_activites, String type, String localisation) {
		super();
		this.titre = titre;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.domaine = domaine;
		this.description = description;
		this.contenu = contenu;
		this.pieces_activites = pieces_activites;
		this.type = type;
		this.localisation = localisation;
	}

}
