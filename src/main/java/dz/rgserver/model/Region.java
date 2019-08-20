package dz.rgserver.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="regions")
public class Region implements Serializable {
	
	public Region() {
		super();
	}
	private static final long serialVersionUID = 5772259672514313577L;
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long    id_region   ;
	private String  designation ;
	private String description  ;
    private String wilaya       ;
	public Region(String designation, String description, String wilaya) {
		super();
		this.designation = designation;
		this.description = description;
		this.wilaya = wilaya;
	}
	public long getId_region() {
		return id_region;
	}
	public void setId_region(long id_region) {
		this.id_region = id_region;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getWilaya() {
		return wilaya;
	}
	public void setWilaya(String wilaya) {
		this.wilaya = wilaya;
	}
		
}
