package dz.rgserver.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "rg_micro")
@PrimaryKeyJoinColumn(name = "id")
public class RgMicro extends Rg {
	
	private String micro;
	
	//GETTERS AND SETTERS

	public String getMicro() {
		return micro;
	}

	public void setMicro(String micro) {
		this.micro = micro;
	} 
	
	
	

}
