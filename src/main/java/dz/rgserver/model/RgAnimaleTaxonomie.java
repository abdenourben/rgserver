package dz.rgserver.model;

public class RgAnimaleTaxonomie {
	
	private RgAnimale rg; 
	private Taxonomie taxonomie;
	
	public RgAnimale getRg() {
		return rg;
	}
	public void setRg(RgAnimale rg) {
		this.rg = rg;
	}
	public Taxonomie getTaxonomie() {
		return taxonomie;
	}
	public void setTaxonomie(Taxonomie taxonomie) {
		this.taxonomie = taxonomie;
	}
	public RgAnimaleTaxonomie(RgAnimale rg, Taxonomie taxonomie) {
		super();
		this.rg = rg;
		this.taxonomie = taxonomie;
	}
}