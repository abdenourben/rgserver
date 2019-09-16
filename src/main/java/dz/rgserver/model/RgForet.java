package dz.rgserver.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "rg_foret")
@PrimaryKeyJoinColumn(name = "id")
public class RgForet extends Rg {
	
	private String foret;
	
	//GETTERS AND SETTERS

	public String getForet() {
		return foret;
	}

	public void setForet(String foret) {
		this.foret = foret;
	} 
	
	

}
