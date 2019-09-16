package dz.rgserver.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "rg_alimentaire")
@PrimaryKeyJoinColumn(name = "id")
public class RgAlimentaire extends Rg {

	private String aliment;
	
	//GETTERS ANS SETTERS

	public String getAliment() {
		return aliment;
	}

	public void setAliment(String aliment) {
		this.aliment = aliment;
	} 
	
	
}
