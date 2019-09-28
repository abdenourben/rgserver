package dz.rgserver.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "rg_alimentaire")
@PrimaryKeyJoinColumn(name = "id")
public class RgAlimentaire extends Rg {

	private String zone; 
	private String exploitation;
	
	//GETTERS ANS SETTERS

	public boolean equal(RgAlimentaire rg1,RgAlimentaire rg2) {
		if (
				(rg1.getZone().equals(rg2.getZone()) &&
				(rg1.getExploitation().equals(rg2.getExploitation()))&&
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

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getExploitation() {
		return exploitation;
	}

	public void setExploitation(String exploitation) {
		this.exploitation = exploitation;
	}
	
	
}
