package dz.rgserver.model;

import java.io.Serializable;
import java.util.Date;
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



@Entity
@Table(name="lois")
public class Loi implements Serializable {

private static final long serialVersionUID = 7985146677274655238L;

/* Attributs */
@Id @GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="id_loi")
private long id_loi;
private String designation;
private Date anneeLoi;
    private String lien_fichier;

    //relation entre loi et User 
    
    @OneToMany(mappedBy="loi",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
@JoinColumn(name="id_loi",referencedColumnName="user-id")
private List<User> users;

    
public Loi() {
}


public List<User> getUsers() {
return users;
}


public void setUsers(List<User> users) {
this.users = users;
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


public Date getAnneeLoi() {
return anneeLoi;
}


public void setAnneeLoi(Date anneeLoi) {
this.anneeLoi = anneeLoi;
}


public Loi(String designation, Date anneeLoi, String lien_fichier) {
super();
this.designation = designation;
this.anneeLoi = anneeLoi;
this.lien_fichier = lien_fichier;
}

}
