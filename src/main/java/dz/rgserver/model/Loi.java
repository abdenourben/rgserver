package dz.rgserver.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="loi")
public class Loi implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String designation;
    private String lienFichier;
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-mm-dd")
    private  @DateTimeFormat(pattern = "yyyy-mm-dd") Date annee_loi;

    //relation entre loi et User 
    @OneToMany
    @JsonIgnore
	private List<User> users;

    //relation loi_file 
    @OneToOne
	@JsonIgnore
	private DBFile file;
    
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

	public Date getAnnee_loi() {
		return annee_loi;
	}

	public void setAnnee_loi(Date annee_loi) {
		this.annee_loi = annee_loi;
	}

	public Loi(String designation, String lienFichier, Date annee_loi) {
		super();
		this.designation = designation;
		this.lienFichier = lienFichier;
		this.annee_loi = annee_loi;
	}

	public Loi() {
		super();
	}
	
}