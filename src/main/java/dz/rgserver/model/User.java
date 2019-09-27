package dz.rgserver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

@Entity
@Table(name = "utilisateur")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String email;
    private String password;
       

    //@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    //@JoinTable(name = "UTILISATEUR_ROLES", joinColumns = {
            //@JoinColumn(name = "UTILISATEUR_ID") }, inverseJoinColumns = {
            //@JoinColumn(name = "ROLE_ID") })
    //private Set<Role> roles;
    

    @ManyToOne
    @JsonIgnore
    private Role role; 
    
    //relation user loi
    @ManyToOne
    @JsonIgnore
    private Loi loi;
    
    //relation user-rg
    @ManyToOne
    @JsonIgnore
    private Rg rg;
    
    //relation User institution
    @ManyToOne
    @JsonIgnore
    private Institution institution;
    
  //relation user-activite
    @ManyToOne
    @JsonIgnore
    private Activite activite;
    
    //GETTERS AND SETTERS

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}

/*import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "utilisateur")

public class User {

@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="user_id")
private int id; 
@Column
private String firstName; 
@Column
private String lastName; 
@Column
@JsonIgnore
private String password;
@Column
private String username;

//Gestion des relations 

//relation user-activite
@ManyToOne
@JoinColumn(name="id_activite")
private Activite activite;
//relation user-institution
@ManyToOne
@JoinColumn(name="id_institution")
private Institution institution;

//relation user-loi 
@ManyToOne
@JoinColumn(name="id_loi")
private Loi loi;
//relation user-demandePermis
@ManyToOne
@JoinColumn(name="id_demande")
private DemandePermis demande;

//relation user-rg
@ManyToOne
@JoinColumn(name="id_ressource")
private Rg rg;

//relation User_Role
@ManyToOne
@JoinColumn(name="role_id")
private Role role;

public Institution getInstitution() {
return institution;
}

public void setInstitution(Institution institution) {
this.institution = institution;
}

public Loi getLoi() {
return loi;
}

public void setLoi(Loi loi) {
this.loi = loi;
}

public DemandePermis getDemande() {
return demande;
}

public void setDemande(DemandePermis demande) {
this.demande = demande;
}

public Rg getRessource() {
return rg;
}

public void setRessource(Rg rg) {
this.ressource = rg;
}

public int getId() {
return id;
}

public void setId(int id) {
this.id = id;
}

public String getFirstName() {
return firstName;
}

public void setFirstName(String firstName) {
this.firstName = firstName;
}

public String getLastName() {
return lastName;
}

public void setLastName(String lastName) {
this.lastName = lastName;
}

public String getPassword() {
return password;
}

public void setPassword(String password) {
this.password = password;
}

public String getUsername() {
return username;
}

public void setUsername(String username) {
this.username = username;
}
}*/
