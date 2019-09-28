package dz.rgserver.model;

import dz.rgserver.model.RgMarine;
import dz.rgserver.model.Institution;

public class RgTaxonomieObject {
	
	private RgMarine rg; 
	private Taxonomie taxonomie;
	
	public RgMarine getRg() {
		return rg;
	}
	public void setRg(RgMarine rg) {
		this.rg = rg;
	}
	public Taxonomie getTaxonomie() {
		return taxonomie;
	}
	public void setTaxonomie(Taxonomie taxonomie) {
		this.taxonomie = taxonomie;
	}
	public RgTaxonomieObject(RgMarine rg, Taxonomie taxonomie) {
		super();
		this.rg = rg;
		this.taxonomie = taxonomie;
	}

	

}

