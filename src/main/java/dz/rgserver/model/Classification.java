package dz.rgserver.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="classifications")
public class Classification implements Serializable {

	private static final long serialVersionUID = -2220440863660445281L;

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id_classification;
	private String designation;
	public long getId_classification() {
		return id_classification;
	}
	public Classification(String designation) {
		super();
		this.designation = designation;
	}
	public void setId_classification(long id_classification) {
		this.id_classification = id_classification;
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
