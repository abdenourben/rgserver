package dz.rgserver.model;

public class RgAlimentaireTaxonomie {
	
	private RgAlimentaire rg; 
	private Taxonomie taxonomie;
	
	public RgAlimentaire getRg() {
		return rg;
	}
	public void setRg(RgAlimentaire rg) {
		this.rg = rg;
	}
	public Taxonomie getTaxonomie() {
		return taxonomie;
	}
	public void setTaxonomie(Taxonomie taxonomie) {
		this.taxonomie = taxonomie;
	}
	public RgAlimentaireTaxonomie(RgAlimentaire rg, Taxonomie taxonomie) {
		super();
		this.rg = rg;
		this.taxonomie = taxonomie;
	}
}