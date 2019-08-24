package dz.rgserver.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="utilisationCommerciales")
public class UtilisationCommerciale implements Serializable {

private static final long serialVersionUID = -8632745985374386237L;

@Id @GeneratedValue(strategy = GenerationType.AUTO)

@Column(name="id_use_commercile")
private long id_use_commercile;
private String description; 
private String secteur;

   //relation Usage_com et RG
@ManyToOne
@JoinColumn(name="d_use_commercile")
private RessourceGenetique ressourceGenetiques;


public RessourceGenetique getRessourceGenetiques() {
return ressourceGenetiques;
}

public void setRessourceGenetiques(RessourceGenetique ressourceGenetiques) {
this.ressourceGenetiques = ressourceGenetiques;
}

public UtilisationCommerciale() {
}

public UtilisationCommerciale(String description, String secteur) {
super();
this.description = description;
this.secteur = secteur;
}

public long getId_use_commercile() {
return id_use_commercile;
}

public void setId_use_commercile(long id_use_commercile) {
this.id_use_commercile = id_use_commercile;
}

public String getDescription() {
return description;
}

public void setDescription(String description) {
this.description = description;
}

public String getSecteur() {
return secteur;
}

public void setSecteur(String secteur) {
this.secteur = secteur;
}

}