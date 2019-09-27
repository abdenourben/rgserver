package dz.rgserver.model;

import java.util.List;

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

	public RgMarine() {
		super();
		// TODO Auto-generated constructor stub
	}


	public boolean equal(RgMarine rg1,RgMarine rg2) {
		if (
				(rg1.getMarine().equals(rg2.getMarine()) &&
				(rg1.getDescription().equals(rg2.getDescription()))&&
				(rg1.getCycleVie().equals(rg2.getCycleVie()))&&
				(rg1.getEnvironnement().equals(rg2.getEnvironnement()))&&
				(rg1.getFormuleChimique().equals(rg2.getFormuleChimique())) &&
				//(rg1.getMarine().equals(rg2.getMarine())) &&
				(rg1.getMorphologie().equals(rg2.getMorphologie())) &&
				(rg1.getNomCommunAr().equals(rg2.getNomCommunAr()))&&
				(rg1.getNomCommunFr().equals(rg2.getNomCommunFr()))&&
				(rg1.getNomScientifique().equals(rg2.getNomScientifique())) &&
				(rg1.getStructure().equals(rg2.getStructure())) &&
				(rg1.getTransmission().equals(rg2.getTransmission()))
			
						)
				) 
				  
		return true;
		else return false;
	}
	
	
}
