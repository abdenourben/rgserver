package dz.rgserver.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="regions")
public class Region implements Serializable {

public Region() {
super();
}
private static final long serialVersionUID = 5772259672514313577L;
@Id @GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="id_region")
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
//relation region-RG

@ManyToMany(mappedBy = "regions")
private List<RessourceGenetique> ressourceGenetiques;


public long getId_region() {
return id_region;
}
public List<RessourceGenetique> getRessourceGenetiques() {
return ressourceGenetiques;
}
public void setRessourceGenetiques(List<RessourceGenetique> ressourceGenetiques) {
this.ressourceGenetiques = ressourceGenetiques;
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
