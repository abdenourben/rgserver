package dz.rgserver.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "rg_micro")
@PrimaryKeyJoinColumn(name = "id")
public class RgMicro extends Rg {
	
	private String structure;
	private String transmission;
	private String symptome; 
	
	//ADD ATTRIBUTS
	
	//GETTERS AND SETTERS


	public boolean equal(RgMicro rg1,RgMicro rg2) {
		if (
				(rg1.getStructure().equals(rg2.getStructure()) &&
				(rg1.getTransmission().equals(rg2.getTransmission())) &&
				(rg1.getSymptome().equals(rg2.getSymptome())) &&
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

	public String getStructure() {
		return structure;
	}

	public void setStructure(String structure) {
		this.structure = structure;
	}

	public String getTransmission() {
		return transmission;
	}

	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}

	public String getSymptome() {
		return symptome;
	}

	public void setSymptome(String symptome) {
		this.symptome = symptome;
	}
	
	
	

}
