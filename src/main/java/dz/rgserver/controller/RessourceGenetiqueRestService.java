package dz.rgserver.controller;

import java.util.List;
import dz.rgserver.dao.RessourceGenetiqueRepository;
import dz.rgserver.model.RessourceGenetique;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class RessourceGenetiqueRestService {
	
	@Autowired
	private RessourceGenetiqueRepository ressourceGenetiqueRepository;
	
	
	@RequestMapping(value="/ressourceGenetiques", method = RequestMethod.GET)
	public List<RessourceGenetique> getAllRessourceGenetiques(){
	
		return ressourceGenetiqueRepository.findAll();
	}
	
	
	
	@RequestMapping(value="/ressourceGenetiques/{id}", method = RequestMethod.GET)
	public RessourceGenetique getOneRessourceGenetique(@PathVariable long id ){
	
		return ressourceGenetiqueRepository.findById(id).get();
	}
	
	

	@RequestMapping(value="/ressourceGenetiques", method = RequestMethod.POST)
	public RessourceGenetique saveInstituion(@RequestBody RessourceGenetique ressourceGenetique ){
	
		return ressourceGenetiqueRepository.save(ressourceGenetique);
	}
	
	
	@RequestMapping(value="/ressourceGenetiques/{id}", method = RequestMethod.DELETE)
	public  boolean deleteRessourceGenetique(@PathVariable long id ){
	
		ressourceGenetiqueRepository.deleteById(id);
		return true;
	}
	
	
	
	@RequestMapping(value="/ressourceGenetiques/{id}", method = RequestMethod.PUT)
	public RessourceGenetique updateInstituion(@PathVariable long id ,@RequestBody RessourceGenetique ressourceGenetique ){
	
		ressourceGenetique.setId_ressource(id);
		return ressourceGenetiqueRepository.save(ressourceGenetique);
	}
	

	@RequestMapping(value="/chercherRessourceGenetiques", method = RequestMethod.GET)
	public Page<RessourceGenetique> chercherRessourceGenetiques(
			@RequestParam(name="mc",defaultValue = "") String mc, 
			@RequestParam(name="page",defaultValue = "0") int page, 
			@RequestParam(name="size",defaultValue = "5") int size){
	        
		return ressourceGenetiqueRepository.chercherRessourceGenetiques("%"+mc+"%", new PageRequest(page, size));
	}
	
	
}
