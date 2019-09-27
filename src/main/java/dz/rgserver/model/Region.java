package dz.rgserver.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="region")
public class Region implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String  designation;
	private String description;
    private String wilaya;
 
	//relation region-RG
	@ManyToOne
	@JsonIgnore
	private Rg rg;
	
	//relation region-users
	@ManyToMany
	@JsonIgnore
	private List<User> users;
	
	//GETTERS AND SETTERS
	public long getId() {
		return id;
	}

	public Region(String designation, String description, String wilaya) {
		super();
		this.designation = designation;
		this.description = description;
		this.wilaya = wilaya;
	}

	

	public Rg getRg() {
		return rg;
	}

	public void setRg(Rg rg) {
		this.rg = rg;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public void setId(long id) {
		this.id = id;
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

	public Region() {
		super();
	}

		
}