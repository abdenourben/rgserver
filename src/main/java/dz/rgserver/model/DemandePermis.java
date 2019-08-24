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

@Entity
@Table(name="demandesPermis")
public class DemandePermis implements Serializable{

private static final long serialVersionUID = -6483665147880708156L;

@Id @GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="id_demande")
private long id_demande;
private String etat; //de la demande, etapes du workflow
public DemandePermis(String etat, String categorie) {
super();
this.etat = etat;
this.categorie = categorie;
}
//relation demande _user
@OneToMany(mappedBy="demande",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
@JoinColumn(name="id_demande",referencedColumnName="user-id")
private List<User> users;

public List<User> getUsers() {
return users;
}

public void setUsers(List<User> users) {
this.users = users;
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
