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
	public boolean equal(RgAnimale rg1,RgAnimale rg2) {
		if (
				(rg1.getAnimale().equals(rg2.getAnimale()) &&
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
