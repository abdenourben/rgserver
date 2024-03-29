package dz.rgserver.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="activitie")
public class Activite implements Serializable {
	
	private static final long serialVersionUID = 1L;
	public Activite(String titre, Date date_debut, Date date_fin, String domaine, String description, String contenu,
			String piecesActivites, String type, String localisation) {
		super();
		this.titre = titre;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.domaine = domaine;
		this.description = description;
		this.contenu = contenu;
		this.piecesActivites = piecesActivites;
		this.type = type;
		this.localisation = localisation;
		
	}

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String titre;
	@Temporal (TemporalType.DATE)
	private @DateTimeFormat(pattern = "yyyy-mm-dd")Date date_debut;
	@Temporal (TemporalType.DATE)
	private @DateTimeFormat(pattern = "yyyy-mm-dd") Date date_fin;
	private String domaine;
	private String description;
	private String contenu; //resume, text
	private String piecesActivites; //images; videos
	private String type; // projet, event
	private String localisation; //address of event

	//relation with users 
	@OneToMany
	@JsonIgnore
	private List<User> users;
	
	//relation with image
	@OneToMany
	@JsonIgnore
	private List<Image> images;
	
	//relation with file
	@OneToMany
	@JsonIgnore
	private List<DBFile> files;
	
	
	//GETTERS AND SETTERS

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
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

	public String getPiecesActivites() {
		return piecesActivites;
	}

	public void setPiecesActivites(String piecesActivites) {
		this.piecesActivites = piecesActivites;
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

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	//CONSTRUCTORS

	public Activite() {
		super();
	}

}