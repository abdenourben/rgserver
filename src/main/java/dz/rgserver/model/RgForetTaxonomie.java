package dz.rgserver.model;

public class RgForetTaxonomie {
	
	private RgForet rg; 
	private Taxonomie taxonomie;
	
	public RgForet getRg() {
		return rg;
	}
	public void setRg(RgForet rg) {
		this.rg = rg;
	}
	public Taxonomie getTaxonomie() {
		return taxonomie;
	}
	public void setTaxonomie(Taxonomie taxonomie) {
		this.taxonomie = taxonomie;
	}
	public RgForetTaxonomie(RgForet rg, Taxonomie taxonomie) {
		super();
		this.rg = rg;
		this.taxonomie = taxonomie;
	}

	

}