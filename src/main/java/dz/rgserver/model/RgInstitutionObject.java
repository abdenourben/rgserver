package dz.rgserver.model;

import dz.rgserver.model.RgMarine;
import dz.rgserver.model.Institution;

public class RgInstitutionObject {
	
	private RgMarine rg; 
	private Institution institution;
	
	public RgMarine getRg() {
		return rg;
	}
	public void setRg(RgMarine rg) {
		this.rg = rg;
	}
	public Institution getInstitution() {
		return institution;
	}
	public void setInstitution(Institution institution) {
		this.institution = institution;
	}
	
	public RgInstitutionObject(RgMarine rg, Institution institution) {
		super();
		this.rg = rg;
		this.institution = institution;
	} 
	

}

