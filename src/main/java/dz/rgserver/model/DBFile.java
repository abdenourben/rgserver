package dz.rgserver.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "files")
public class DBFile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   
    private Long id;

    private String fileName;

    private String fileType;

    @Lob
    private byte[] data;
    
    //relation file-RG 
    @ManyToOne
	@JsonIgnore
	private Rg rg;

    //relation file_ institution
    @ManyToOne
	@JsonIgnore
	private Institution institution;
    
    
  //relation file_ activite
    @ManyToOne
	@JsonIgnore
	private Activite activite;
    
    //relation file-permis
    @OneToOne
	@JsonIgnore
	private DemandePermis permis;
    
  //relation file-loi
    @OneToOne
	@JsonIgnore
	private Loi loi;
    
    
    
    
    public DBFile() {

    }

    public DBFile(String fileName, String fileType, byte[] data) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public DBFile(Long id, String fileName, String fileType, byte[] data) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.fileType = fileType;
		this.data = data;
	}

    // Getters and Setters (Omitted for brevity)
    
}

