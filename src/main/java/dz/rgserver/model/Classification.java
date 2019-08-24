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
@Table(name="classifications")
public class Classification implements Serializable {

private static final long serialVersionUID = -2220440863660445281L;

@Id @GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="id_classification")
private long id_classification;
private String designation;

//relation classification-RG
@OneToMany(mappedBy="classification",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
@JoinColumn(name="id_classification",referencedColumnName="id_ressource")
private List<RessourceGenetique> ressourceGenetiques;


public List<RessourceGenetique> getRessourceGenetiques() {
return ressourceGenetiques;
}
public void setRessourceGenetiques(List<RessourceGenetique> ressourceGenetiques) {
this.ressourceGenetiques = ressourceGenetiques;
}
public long getId_classification() {
return id_classification;
}
public Classification(String designation) {
super();
this.designation = designation;
}
public void setId_classification(long id_classification) {
this.id_classification = id_classification;
}
public String getDesignation() {
return designation;
}
public void setDesignation(String designation) {
this.designation = designation;
}
public Classification() {
}
}
