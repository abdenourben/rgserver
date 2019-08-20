package dz.rgserver.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="lois")
public class Loi implements Serializable {

	private static final long serialVersionUID = 7985146677274655238L;

	/* Attributs */
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id_loi;
	private String designation;
    private String lien_fichier;

	
	public Loi() {
	}


	public long getId_loi() {
		return id_loi;
	}


	public void setId_loi(long id_loi) {
		this.id_loi = id_loi;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public String getLien_fichier() {
		return lien_fichier;
	}


	public void setLien_fichier(String lien_fichier) {
		this.lien_fichier = lien_fichier;
	}


	public Loi(long id_loi, String designation, String lien_fichier) {
		super();
		this.id_loi = id_loi;
		this.designation = designation;
		this.lien_fichier = lien_fichier;
	}

	
}
