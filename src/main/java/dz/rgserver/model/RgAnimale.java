package dz.rgserver.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "rg_animale")
@PrimaryKeyJoinColumn(name = "id")
public class RgAnimale extends Rg {
	
	private String production;
	private String elevage;
	private String systemeProd;
	private String conservation;
	
	//GETTERS AND SETTERS

	public boolean equal(RgAnimale rg1,RgAnimale rg2) {
		if (
		
				(rg1.getProduction().equals(rg2.getProduction()) &&
				(rg1.getElevage().equals(rg2.getElevage())) &&
				(rg1.getSystemeProd().equals(rg2.getSystemeProd())) &&
				(rg1.getConservation().equals(rg2.getConservation())) &&	
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

	public String getProduction() {
		return production;
	}

	public void setProduction(String production) {
		this.production = production;
	}

	public String getElevage() {
		return elevage;
	}

	public void setElevage(String elevage) {
		this.elevage = elevage;
	}

	public String getSystemeProd() {
		return systemeProd;
	}

	public void setSystemeProd(String systemeProd) {
		this.systemeProd = systemeProd;
	}

	public String getConservation() {
		return conservation;
	}

	public void setConservation(String conservation) {
		this.conservation = conservation;
	}
	
	

}
