package dz.rgserver.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "rg_animale")
@PrimaryKeyJoinColumn(name = "id")
public class RgAnimale extends Rg {
	
	private String animale;
	
	//GETTERS AND SETTERS

	public String getAnimale() {
		return animale;
	}

	public void setAnimale(String animale) {
		this.animale = animale;
	} 
	
	

}
