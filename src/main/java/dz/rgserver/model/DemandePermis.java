package dz.rgserver.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="demandesPermis")
public class DemandePermis implements Serializable{

	private static final long serialVersionUID = -6483665147880708156L;

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id_demande;
	private String etat; //de la demande, etapes du workflow
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

	private String categorie; //de la demande

	public DemandePermis() {
	}

}
