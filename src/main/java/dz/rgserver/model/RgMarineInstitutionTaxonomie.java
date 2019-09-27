package dz.rgserver.model;


import dz.rgserver.model.RgMarine;
import dz.rgserver.model.Institution;
import dz.rgserver.model.Taxonomie;

public class RgMarineInstitutionTaxonomie {
	
	private RgMarine rgMarine; 
	private Institution institution;
	private Taxonomie taxonomie;
	
	//GETTERS AND SETTERS
	
	public RgMarine getRgMarine() {
		return rgMarine;
	}
	public void setRgMarine(RgMarine rgMarine) {
		this.rgMarine = rgMarine;
	}
	public Institution getInstitution() {
		return institution;
	}
	public void setInstitution(Institution institution) {
		this.institution = institution;
	}
	public Taxonomie getTaxonomie() {
		return taxonomie;
	}
	public void setTaxonomie(Taxonomie taxonomie) {
		this.taxonomie = taxonomie;
	}
	
	//CONSTRUCTORS
	
	public RgMarineInstitutionTaxonomie(RgMarine rgMarine, Institution institution, Taxonomie taxonomie) {
		super();
		this.rgMarine = rgMarine;
		this.institution = institution;
		this.taxonomie = taxonomie;
	}
	
	

}
