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
@Table(name="utilisationTraditionnelles")

public class UtilisationTraditionnelle implements Serializable {

private static final long serialVersionUID = 975381259656039372L;
@Id @GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="id_use_trad")
private long id_use_trad;
private String description;
private String recette_production;

@ManyToOne
@JoinColumn(name="id_use_trad")
private RessourceGenetique ressourceGenetiques;

public UtilisationTraditionnelle() {
}

public RessourceGenetique getRessourceGenetiques() {
return ressourceGenetiques;
}

public void setRessourceGenetiques(RessourceGenetique ressourceGenetiques) {
this.ressourceGenetiques = ressourceGenetiques;
}

public long getId_use_trad() {
return id_use_trad;
}

public void setId_use_trad(long id_use_Traditionnelles) {
this.id_use_trad = id_use_Traditionnelles;
}

public String getDescription() {
return description;
}

public void setDescription(String description) {
this.description = description;
}

public String getRecette_production() {
return recette_production;
}

public void setRecette_production(String recette_production) {
this.recette_production = recette_production;
}

public UtilisationTraditionnelle(String description, String recette_production) {
super();
this.description = description;
this.recette_production = recette_production;
}

}