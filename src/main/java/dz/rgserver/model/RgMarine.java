package dz.rgserver.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "rg_marine")
@PrimaryKeyJoinColumn(name = "id")
public class RgMarine extends Rg {

	private String marine;
	
	//GETTERS AND SETTERS

	public String getMarine() {
		return marine;
	}

	public void setMarine(String marine) {
		this.marine = marine;
	} 
	
}
