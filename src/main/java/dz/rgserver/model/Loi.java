package dz.rgserver.model;

import java.io.Serializable;
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

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="loi")
public class Loi implements Serializable {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_loi")
	private long id;
	private String designation;
    private String lienFichier;

    //relation entre loi et User 
    
    @OneToMany(mappedBy="loi",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JsonIgnore
	private List<User> users;

    //GETTERS AND SETTERS
    
	public long getId() {
		return id;
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

	public String getLienFichier() {
		return lienFichier;
	}

	public void setLienFichier(String lienFichier) {
		this.lienFichier = lienFichier;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
}