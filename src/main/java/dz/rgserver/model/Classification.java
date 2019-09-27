package dz.rgserver.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="classifications")
public class Classification implements Serializable {

	private static final long serialVersionUID = -2220440863660445281L;

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String designation;
	
	//relation classification-RG
	@OneToMany
	@JsonIgnore
	private List<Rg> rg;
	
	
	public Classification(String designation) {
		super();
		this.designation = designation;
	}
	public List<Rg> getRg() {
		return rg;
	}
	public void setRg(List<Rg> rg) {
		this.rg = rg;
	}
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Classification() {
	}

}
