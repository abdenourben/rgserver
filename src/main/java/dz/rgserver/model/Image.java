package dz.rgserver.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="images")

public class Image implements Serializable {

private static final long serialVersionUID = 5836911806971607169L;

@Id @GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="id_image")
private long id_image;
private String titre;
private String description;
private String chemin;
private String type;

//relation image-RG
@OneToOne(mappedBy="rimage",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
@JoinColumn(name="id_image",referencedColumnName="id_ressource")
private RessourceGenetique ressourceGenetiques;


public RessourceGenetique getRessourceGenetiques() {
return ressourceGenetiques;
}

public void setRessourceGenetiques(RessourceGenetique ressourceGenetiques) {
this.ressourceGenetiques = ressourceGenetiques;
}

public Image() {
}

public Image(String titre, String description, String chemin, String type) {
super();
this.titre = titre;
this.description = description;
this.chemin = chemin;
this.type = type;
}

public long getId_image() {
return id_image;
}

public void setId_image(long id_image) {
this.id_image = id_image;
}

public String getTitre() {
return titre;
}

public void setTitre(String titre) {
this.titre = titre;
}

public String getDescription() {
return description;
}

public void setDescription(String description) {
this.description = description;
}

public String getChemin() {
return chemin;
}

public void setChemin(String chemin) {
this.chemin = chemin;
}

public String getType() {
return type;
}

public void setType(String type) {
this.type = type;
}

public void setid_image(long id) {
this.id_image = id;
}

}
