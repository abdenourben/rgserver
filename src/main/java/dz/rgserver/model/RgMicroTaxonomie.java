package dz.rgserver.model;

public class RgMicroTaxonomie {
	
	private RgMicro rg; 
	private Taxonomie taxonomie;
	
	public RgMicro getRg() {
		return rg;
	}
	public void setRg(RgMicro rg) {
		this.rg = rg;
	}
	public Taxonomie getTaxonomie() {
		return taxonomie;
	}
	public void setTaxonomie(Taxonomie taxonomie) {
		this.taxonomie = taxonomie;
	}
	public RgMicroTaxonomie(RgMicro rg, Taxonomie taxonomie) {
		super();
		this.rg = rg;
		this.taxonomie = taxonomie;
	}
}