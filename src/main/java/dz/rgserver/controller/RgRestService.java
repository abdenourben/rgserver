package dz.rgserver.controller;

import java.util.ArrayList;
import java.util.List;

import dz.rgserver.dao.RgAlimentaireRepository;
import dz.rgserver.dao.RgAnimaleRepository;
import dz.rgserver.dao.RgForetRepository;
import dz.rgserver.dao.RgMarineRepository;
import dz.rgserver.dao.RgMicroRepository;
import dz.rgserver.dao.RgRepository;
import dz.rgserver.dao.VersionRepository;
import dz.rgserver.model.Activite;
import dz.rgserver.model.Institution;
import dz.rgserver.model.Region;
import dz.rgserver.model.Rg;
import dz.rgserver.model.RgAlimentaire;
import dz.rgserver.model.RgAlimentaireTaxonomie;
import dz.rgserver.model.RgAnimale;
import dz.rgserver.model.RgAnimaleTaxonomie;
import dz.rgserver.model.RgForet;
import dz.rgserver.model.RgForetTaxonomie;
import dz.rgserver.model.RgMarine;
import dz.rgserver.model.RgMicro;
import dz.rgserver.model.RgMicroTaxonomie;
import dz.rgserver.model.RgTaxonomieObject;
import dz.rgserver.model.Taxonomie;
import dz.rgserver.model.Version;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin("*")
public class RgRestService {
	
	@Autowired
	private RgRepository rgRepository;
	
	@Autowired
	private RgMarineRepository rgMarineRepository;
	
	@Autowired
	private RgAlimentaireRepository rgAlimentaireRepository; 
	
	@Autowired
	private RgAnimaleRepository rgAnimaleRepository; 
	
	@Autowired
	private RgMicroRepository rgMicroRepository; 
	
	@Autowired
	private RgForetRepository rgForetRepository; 
	
	@Autowired
	private VersionRepository versionRepository; 
	
	/*****************************GET ALL   ******************************/
	
    @PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value="/rg", method = RequestMethod.GET)
	public List<Rg> listRg(){
		return rgRepository.findAll();
	}
    @RequestMapping(value = "/rg/find/{id}", method = RequestMethod.GET)
   	public List<Rg> find(@PathVariable long id) {
   		return rgRepository.findByInstitutionId(id);  
   	}
    
   
    /*****************************GET ALL VERSIONS OF 1 RG   ******************************/
    
    @RequestMapping(value="/versions", method = RequestMethod.GET)
   	public Page<Version> getAllVersionOfRG (
   	
   	//return versionRepositori.getVersionByIdRessouce();
   	
   	@RequestParam(name="nbr",defaultValue = "0") Long nbr, 
   	@RequestParam(name="page",defaultValue = "0") int page, 
   	@RequestParam(name="size",defaultValue = "11") int size){
       
   return versionRepository.getVersionByIdRessouce(nbr, new PageRequest(page, size));
   }
    
 /*********************   GET ONE   ******************************************/
  
    @RequestMapping(value="/rg/{id}", method = RequestMethod.GET)
	public Rg getOneRg(@PathVariable long id ){
	
		return rgRepository.findById(id).get();
	}
    
	/***************************** MARINE  ***********************************************/

    @PreAuthorize("hasRole('ADMIN')")
  	@RequestMapping(value="/rg/marine", method = RequestMethod.GET)
  	public List<RgMarine> listRgMarine(){
  		return rgMarineRepository.findAll();
  	}
    
   /* @RequestMapping(value = "/rg/marine", method = RequestMethod.POST)
    public void saveRgMarine(@RequestBody RgMarine rg) {
    	rg.setNumVersion(0);
    	rg.setEtatValidation(false);
    	 rgMarineRepository.save(rg);
    	 Version v=new Version();
    	 
     	v.setNomCommunFr(rg.getNomCommunFr());
     	v.setNomCommunAr(rg.getNomCommunAr());
     	v.setNomScientifique(rg.getNomScientifique());
     	
     	v.setDescription(rg.getDescription());
     	v.setMorphologie(rg.getMorphologie());
     	v.setFormuleChimique(rg.getFormuleChimique());
     	v.setStructure(rg.getStructure());
     	v.setEnvironnement(rg.getEnvironnement());
     	v.setTransmission(rg.getTransmission());
     	v.setCycleVie(rg.getCycleVie());
     	v.setMarine(rg.getMarine());
     	v.setDate_version();
 		v.setType_action("création");
 		v.setIdRessource(rg.getId());
 		v.setNumVersion(0);
 		versionRepository.save(v);
 		
 		
    } */
    
    
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/rg/marine", method = RequestMethod.POST)
    public RgTaxonomieObject saveRgMarine(@RequestBody RgTaxonomieObject rgTaxonomieObject) {	
    	
    	RgMarine rg = new RgMarine();
    	Taxonomie taxo = new Taxonomie(); 
    	taxo = rgTaxonomieObject.getTaxonomie(); 
    	rg = rgTaxonomieObject.getRg(); 
    		
    	rg.setNumVersion(0);
    	rg.setEtatValidation(false);
    	rg.setTaxonomie(taxo);
    	rgMarineRepository.save(rg);  
    	Version v=new Version();
   	 
     	v.setNomCommunFr(rg.getNomCommunFr());
     	v.setNomCommunAr(rg.getNomCommunAr());
     	v.setNomScientifique(rg.getNomScientifique());    	
     	v.setDescription(rg.getDescription());
     	v.setMorphologie(rg.getMorphologie());
     	v.setFormuleChimique(rg.getFormuleChimique());
     	v.setStructure(rg.getStructure());
     	v.setEnvironnement(rg.getEnvironnement());
     	v.setTransmission(rg.getTransmission());
     	v.setCycleVie(rg.getCycleVie());
     	v.setDate_version();
 		v.setType_action("création");
 		v.setIdRessource(rg.getId());
 		v.setNumVersion(0);
 		versionRepository.save(v);
    	return rgTaxonomieObject;
    }
    
   
 /* @RequestMapping(value="/rg/marine/{id}", method = RequestMethod.PUT)
	public RgMarine updateRgMarine(@PathVariable long id ,@RequestBody RgMarine rg ){
		rg.setId(id);
	 return rgMarineRepository.save(rg);
    }*/
	@RequestMapping(value="/rg/marine/{id}", method = RequestMethod.PUT)
	public boolean updateRgMarine(@PathVariable long id,@RequestBody RgMarine rg ){
		
		
		RgMarine old=rgMarineRepository.getOne(id);
		if (old.equal(old,rg)){
			return false;
		}
		else {
			int nbr=old.getNumVersion();
			int nbr2=nbr+1;
			rg.setNumVersion(nbr2);
			rg.setId(id);
			rgMarineRepository.save(rg);
		Version v=new Version();
		 
	    	v.setNomCommunFr(rg.getNomCommunFr());
	    	v.setNomCommunAr(rg.getNomCommunAr());
	    	v.setNomScientifique(rg.getNomScientifique());
	    	v.setIdRessource(rg.getId());
	    	
	    	v.setDescription(rg.getDescription());
	    	v.setMorphologie(rg.getMorphologie());
	    	v.setFormuleChimique(rg.getFormuleChimique());
	    	v.setEnvironnement(rg.getEnvironnement());
	    	v.setTransmission(rg.getTransmission());
	    	v.setCycleVie(rg.getCycleVie());
			v.setDate_version();
			v.setNumVersion(nbr2);
			v.setType_action("Modification");
		versionRepository.save(v);
		return true;
		}
	}
	
    
	/*****************************ALIMENT  *********************************************/

    @PreAuthorize("hasRole('ADMIN')")
  	@RequestMapping(value="/rg/alimentaire", method = RequestMethod.GET)
  	public List<RgAlimentaire> listRgAlimentaire(){
  		return rgAlimentaireRepository.findAll(); 
    }
    
   
    
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/rg/alimentaire", method = RequestMethod.POST)
    public RgAlimentaireTaxonomie saveRgAlimentaire(@RequestBody RgAlimentaireTaxonomie rgAlimentaireTaxonomie) {	
    	
    	RgAlimentaire rg = new RgAlimentaire();
    	Taxonomie taxo = new Taxonomie(); 
    	taxo = rgAlimentaireTaxonomie.getTaxonomie(); 
    	rg = rgAlimentaireTaxonomie.getRg(); 
    		
    	rg.setNumVersion(0);
    	rg.setEtatValidation(false);
    	rg.setTaxonomie(taxo);
    	rgAlimentaireRepository.save(rg);  
    	Version v=new Version();
   	 
     	v.setNomCommunFr(rg.getNomCommunFr());
     	v.setNomCommunAr(rg.getNomCommunAr());
     	v.setNomScientifique(rg.getNomScientifique());    	
     	v.setDescription(rg.getDescription());
     	v.setMorphologie(rg.getMorphologie());
     	v.setFormuleChimique(rg.getFormuleChimique());
     	v.setStructure(rg.getStructure());
     	v.setEnvironnement(rg.getEnvironnement());
     	v.setTransmission(rg.getTransmission());
     	v.setCycleVie(rg.getCycleVie());
     	v.setZone(rg.getZone());
     	v.setExploitation(rg.getExploitation());
     	v.setDate_version();
 		v.setType_action("création");
 		v.setIdRessource(rg.getId());
 		v.setNumVersion(0);
 		versionRepository.save(v);
    	return rgAlimentaireTaxonomie;
    }
    
	@RequestMapping(value="/rg/alimentaire/{id}", method = RequestMethod.DELETE)
	public  boolean deleteRgAliment(@PathVariable long id ){
		
		RgAlimentaire rg= rgAlimentaireRepository.findById(id).get();
       Version v=new Version();
     
    	v.setNomCommunFr(rg.getNomCommunFr());
    	v.setNomCommunAr(rg.getNomCommunAr());
    	v.setNomScientifique(rg.getNomScientifique());
    	
    	v.setDescription(rg.getDescription());
    	v.setMorphologie(rg.getMorphologie());
    	v.setFormuleChimique(rg.getFormuleChimique());
    	v.setStructure(rg.getStructure());
    	v.setEnvironnement(rg.getEnvironnement());
    	v.setTransmission(rg.getTransmission());
    	v.setCycleVie(rg.getCycleVie());
    	v.setZone(rg.getZone());
     	v.setExploitation(rg.getExploitation());
		
		
		v.setType_action("Suppression");
		v.setIdRessource(rg.getId());
		v.setDate_version();
		versionRepository.save(v);

	
		rgRepository.deleteById(id);
		return true;
	}
	@RequestMapping(value="/rg/alimentaire/{id}", method = RequestMethod.PUT)
	public boolean updateRgAliment(@PathVariable long id,@RequestBody RgAlimentaire rg ){
		
		
		RgAlimentaire old=rgAlimentaireRepository.getOne(id);
		if (old.equal(old,rg)){
			return false;
		}
		else {
			int nbr=old.getNumVersion();
			int nbr2=nbr+1;
			rg.setNumVersion(nbr2);
			rg.setId(id);
			rgAlimentaireRepository.save(rg);
		Version v=new Version();
		 
	    	v.setNomCommunFr(rg.getNomCommunFr());
	    	v.setNomCommunAr(rg.getNomCommunAr());
	    	v.setNomScientifique(rg.getNomScientifique());
	    	v.setIdRessource(rg.getId());
	    	
	    	v.setDescription(rg.getDescription());
	    	v.setMorphologie(rg.getMorphologie());
	    	v.setFormuleChimique(rg.getFormuleChimique());
	    	v.setStructure(rg.getStructure());
	    	v.setEnvironnement(rg.getEnvironnement());
	    	v.setTransmission(rg.getTransmission());
	    	v.setCycleVie(rg.getCycleVie());
	    	v.setZone(rg.getZone());
	    	v.setExploitation(rg.getExploitation());
			v.setDate_version();
			v.setNumVersion(nbr2);
			v.setType_action("Modification");
		versionRepository.save(v);
		return true;
		}
	}
	
	/*****************************ANIMAL  *************************************************/

    
    @PreAuthorize("hasRole('ADMIN')")
  	@RequestMapping(value="/rg/animale", method = RequestMethod.GET)
  	public List<RgAnimale> listRgAnimale(){
  		return rgAnimaleRepository.findAll(); 
    }
     
    
    
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/rg/animale", method = RequestMethod.POST)
    public RgAnimaleTaxonomie saveRgAnimale(@RequestBody RgAnimaleTaxonomie rgAnimaleTaxonomie) {	
    	
    	RgAnimale rg = new RgAnimale();
    	Taxonomie taxo = new Taxonomie(); 
    	taxo = rgAnimaleTaxonomie.getTaxonomie(); 
    	rg = rgAnimaleTaxonomie.getRg(); 
    		
    	rg.setNumVersion(0);
    	rg.setEtatValidation(false);
    	rg.setTaxonomie(taxo);
    	rgAnimaleRepository.save(rg);  
    	Version v=new Version();
   	 
     	v.setNomCommunFr(rg.getNomCommunFr());
     	v.setNomCommunAr(rg.getNomCommunAr());
     	v.setNomScientifique(rg.getNomScientifique());    	
     	v.setDescription(rg.getDescription());
     	v.setMorphologie(rg.getMorphologie());
     	v.setFormuleChimique(rg.getFormuleChimique());
     	v.setStructure(rg.getStructure());
     	v.setEnvironnement(rg.getEnvironnement());
     	v.setTransmission(rg.getTransmission());
     	v.setCycleVie(rg.getCycleVie());
     	v.setProduction(rg.getProduction());
     	v.setSystemeProd(rg.getSystemeProd());
     	v.setElevage(rg.getElevage());
     	v.setConservation(rg.getConservation());
     	v.setDate_version();
 		v.setType_action("création");
 		v.setIdRessource(rg.getId());
 		v.setNumVersion(0);
 		versionRepository.save(v);
    	return rgAnimaleTaxonomie;
    }
    
    
   /* @RequestMapping(value = "/rg/animal", method = RequestMethod.POST)
    public void saveRgAnimale(@RequestBody RgAnimale rg) {
    	rg.setNumVersion(0);
    }
    */
	@RequestMapping(value="/rg/animale/{id}", method = RequestMethod.DELETE)
	public  boolean deleteRgAnimal(@PathVariable long id ){
		
		RgAnimale rg= rgAnimaleRepository.findById(id).get();
       Version v=new Version();
       
    	v.setNomCommunFr(rg.getNomCommunFr());
    	v.setNomCommunAr(rg.getNomCommunAr());
    	v.setNomScientifique(rg.getNomScientifique());
    	
    	v.setDescription(rg.getDescription());
    	v.setMorphologie(rg.getMorphologie());
    	v.setFormuleChimique(rg.getFormuleChimique());
    	v.setStructure(rg.getStructure());
    	v.setEnvironnement(rg.getEnvironnement());
    	v.setTransmission(rg.getTransmission());
    	v.setCycleVie(rg.getCycleVie());
    	v.setProduction(rg.getProduction());
     	v.setSystemeProd(rg.getSystemeProd());
     	v.setElevage(rg.getElevage());
     	v.setConservation(rg.getConservation());
		
		
		v.setType_action("Suppression");
		v.setIdRessource(rg.getId());
		v.setDate_version();
		versionRepository.save(v);

	
		rgRepository.deleteById(id);
		return true;
	}
	
	@RequestMapping(value="/rg/animale/{id}", method = RequestMethod.PUT)
	public boolean updateRgAnimal(@PathVariable long id,@RequestBody RgAnimale rg ){
		
		
		RgAnimale old=rgAnimaleRepository.getOne(id);
		if (old.equal(old,rg)){
			return false;
		}
		else {
			int nbr=old.getNumVersion();
			int nbr2=nbr+1;
			rg.setNumVersion(nbr2);
			rg.setId(id);
			rgAnimaleRepository.save(rg);
		Version v=new Version();
		 
	    	v.setNomCommunFr(rg.getNomCommunFr());
	    	v.setNomCommunAr(rg.getNomCommunAr());
	    	v.setNomScientifique(rg.getNomScientifique());
	    	v.setIdRessource(rg.getId());
	    	
	    	v.setDescription(rg.getDescription());
	    	v.setMorphologie(rg.getMorphologie());
	    	v.setFormuleChimique(rg.getFormuleChimique());
	    	v.setStructure(rg.getStructure());
	    	v.setEnvironnement(rg.getEnvironnement());
	    	v.setTransmission(rg.getTransmission());
	    	v.setCycleVie(rg.getCycleVie());
	    	v.setProduction(rg.getProduction());
	     	v.setSystemeProd(rg.getSystemeProd());
	     	v.setElevage(rg.getElevage());
	     	v.setConservation(rg.getConservation());
			v.setDate_version();
			v.setNumVersion(nbr2);
			v.setType_action("Modification");
		versionRepository.save(v);
		return true;
		}
	}
	/*****************************MICRO *********************************************/

    @PreAuthorize("hasRole('ADMIN')")
   	@RequestMapping(value="/rg/micro", method = RequestMethod.GET)
   	public List<RgMicro> listRgMicro(){
   		return rgMicroRepository.findAll(); 
    }
    
    
    
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/rg/micro", method = RequestMethod.POST)
    public RgMicroTaxonomie saveRgMicro(@RequestBody RgMicroTaxonomie rgMicroTaxonomie) {	
    	
    	RgMicro rg = new RgMicro();
    	Taxonomie taxo = new Taxonomie(); 
    	taxo = rgMicroTaxonomie.getTaxonomie(); 
    	rg = rgMicroTaxonomie.getRg(); 
    		
    	rg.setNumVersion(0);
    	rg.setEtatValidation(false);
    	rg.setTaxonomie(taxo);
    	rgMicroRepository.save(rg);  
    	Version v=new Version();
   	 
     	v.setNomCommunFr(rg.getNomCommunFr());
     	v.setNomCommunAr(rg.getNomCommunAr());
     	v.setNomScientifique(rg.getNomScientifique());    	
     	v.setDescription(rg.getDescription());
     	v.setMorphologie(rg.getMorphologie());
     	v.setFormuleChimique(rg.getFormuleChimique());
     	v.setStructure(rg.getStructure());
     	v.setEnvironnement(rg.getEnvironnement());
     	v.setTransmission(rg.getTransmission());
     	v.setCycleVie(rg.getCycleVie());
     	v.setSymptome(rg.getSymptome());
     	v.setDate_version();
 		v.setType_action("création");
 		v.setIdRessource(rg.getId());
 		v.setNumVersion(0);
 		versionRepository.save(v);
    	return rgMicroTaxonomie;
    }
    
    @RequestMapping(value="/rg/micro/{id}", method = RequestMethod.DELETE)
	public  boolean deleteRgMicro(@PathVariable long id ){
		
		RgMicro rg= rgMicroRepository.findById(id).get();
       Version v=new Version();
       
    	v.setNomCommunFr(rg.getNomCommunFr());
    	v.setNomCommunAr(rg.getNomCommunAr());
    	v.setNomScientifique(rg.getNomScientifique());
    	
    	v.setDescription(rg.getDescription());
    	v.setMorphologie(rg.getMorphologie());
    	v.setFormuleChimique(rg.getFormuleChimique());
    	v.setStructure(rg.getStructure());
    	v.setEnvironnement(rg.getEnvironnement());
    	v.setTransmission(rg.getTransmission());
    	v.setCycleVie(rg.getCycleVie());
    	v.setSymptome(rg.getSymptome());
		
		
		v.setType_action("Suppression");
		v.setIdRessource(rg.getId());
		v.setDate_version();
		versionRepository.save(v);

	
		rgRepository.deleteById(id);
		return true;
	}
    
	@RequestMapping(value="/rg/micro/{id}", method = RequestMethod.PUT)
	public boolean updateRgMicro(@PathVariable long id,@RequestBody RgMicro rg ){
		
		
		RgMicro old=rgMicroRepository.getOne(id);
		if (old.equal(old,rg)){
			return false;
		}
		else {
			int nbr=old.getNumVersion();
			int nbr2=nbr+1;
			rg.setNumVersion(nbr2);
			rg.setId(id);
			rgMicroRepository.save(rg);
		Version v=new Version();
		 
	    	v.setNomCommunFr(rg.getNomCommunFr());
	    	v.setNomCommunAr(rg.getNomCommunAr());
	    	v.setNomScientifique(rg.getNomScientifique());
	    	v.setIdRessource(rg.getId());
	    	
	    	v.setDescription(rg.getDescription());
	    	v.setMorphologie(rg.getMorphologie());
	    	v.setFormuleChimique(rg.getFormuleChimique());
	    	v.setStructure(rg.getStructure());
	    	v.setEnvironnement(rg.getEnvironnement());
	    	v.setTransmission(rg.getTransmission());
	    	v.setCycleVie(rg.getCycleVie());
	    	v.setSymptome(rg.getSymptome());
			v.setDate_version();
			v.setNumVersion(nbr2);
			v.setType_action("Modification");
		versionRepository.save(v);
		return true;
		}
	}
	/*****************************FORET  ********************************************/

    @PreAuthorize("hasRole('ADMIN')")
   	@RequestMapping(value="/rg/foret", method = RequestMethod.GET)
   	public List<RgForet> listRgForet(){
   		return rgForetRepository.findAll(); 
    }

    
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/rg/foret", method = RequestMethod.POST)
    public RgForetTaxonomie saveRgForet(@RequestBody RgForetTaxonomie rgForetTaxonomie) {	
    	
    	RgForet rg = new RgForet();
    	Taxonomie taxo = new Taxonomie(); 
    	taxo = rgForetTaxonomie.getTaxonomie(); 
    	rg = rgForetTaxonomie.getRg(); 
    		
    	rg.setNumVersion(0);
    	rg.setEtatValidation(false);
    	rg.setTaxonomie(taxo);
    	rgForetRepository.save(rg);  
    	Version v=new Version();
   	 
     	v.setNomCommunFr(rg.getNomCommunFr());
     	v.setNomCommunAr(rg.getNomCommunAr());
     	v.setNomScientifique(rg.getNomScientifique());    	
     	v.setDescription(rg.getDescription());
     	v.setMorphologie(rg.getMorphologie());
     	v.setFormuleChimique(rg.getFormuleChimique());
     	v.setEnvironnement(rg.getEnvironnement());
     	v.setTransmission(rg.getTransmission());
     	v.setCycleVie(rg.getCycleVie());
     	v.setDate_version();
 		v.setType_action("création");
 		v.setIdRessource(rg.getId());
 		v.setNumVersion(0);
 		versionRepository.save(v);
    	return rgForetTaxonomie;
    }
    
    
    
    @RequestMapping(value="/rg/foret/{id}", method = RequestMethod.DELETE)
	public  boolean deleteRgForet(@PathVariable long id ){
		
		RgForet rg= rgForetRepository.findById(id).get();
       Version v=new Version();
       
    	v.setNomCommunFr(rg.getNomCommunFr());
    	v.setNomCommunAr(rg.getNomCommunAr());
    	v.setNomScientifique(rg.getNomScientifique());
    	
    	v.setDescription(rg.getDescription());
    	v.setMorphologie(rg.getMorphologie());
    	v.setFormuleChimique(rg.getFormuleChimique());
    	v.setEnvironnement(rg.getEnvironnement());
    	v.setTransmission(rg.getTransmission());
    	v.setCycleVie(rg.getCycleVie());
		
		
		v.setType_action("Suppression");
		v.setIdRessource(rg.getId());
		v.setDate_version();
		versionRepository.save(v);

	
		rgRepository.deleteById(id);
		return true;
	}
    
	@RequestMapping(value="/rg/foret/{id}", method = RequestMethod.PUT)
	public boolean updateRgForet(@PathVariable long id,@RequestBody RgForet rg ){
		
		
		RgForet old=rgForetRepository.getOne(id);
		if (old.equal(old,rg)){
			return false;
		}
		else {
			int nbr=old.getNumVersion();
			int nbr2=nbr+1;
			rg.setNumVersion(nbr2);
			rg.setId(id);
			rgForetRepository.save(rg);
		Version v=new Version();
		 
	    	v.setNomCommunFr(rg.getNomCommunFr());
	    	v.setNomCommunAr(rg.getNomCommunAr());
	    	v.setNomScientifique(rg.getNomScientifique());
	    	v.setIdRessource(rg.getId());
	    	
	    	v.setDescription(rg.getDescription());
	    	v.setMorphologie(rg.getMorphologie());
	    	v.setFormuleChimique(rg.getFormuleChimique());
	    	v.setEnvironnement(rg.getEnvironnement());
	    	v.setTransmission(rg.getTransmission());
	    	v.setCycleVie(rg.getCycleVie());
			v.setDate_version();
			v.setNumVersion(nbr2);
			v.setType_action("Modification");
		versionRepository.save(v);
		return true;
		}
	}
	
	@RequestMapping(value="/rg/ValidationRg/{id}", method = RequestMethod.POST)
	public void validationRG(@PathVariable long id){
		
		Rg rg= rgRepository.findById(id).get();
		rg.setEtatValidation(true);
		rgRepository.save(rg);		
	}
	
	   @RequestMapping(value = "/rg/find-institution/{id}", method = RequestMethod.GET)
		public List<Rg> findInstitutions(@PathVariable long id) {
			return rgRepository.findByInstitutionId(id);  
		}
	    
	    @RequestMapping(value = "/rg/find-taxonomie/{id}", method = RequestMethod.GET)
	   	public List<Rg> findTaxonomies(@PathVariable long id) {
	   		return rgRepository.findByTaxonomieId(id); 
	   	}

	
	
}
	
	
    
   
    
