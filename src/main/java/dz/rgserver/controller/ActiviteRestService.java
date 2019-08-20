package dz.rgserver.controller;

import java.util.List;
import dz.rgserver.dao.ActiviteRepository;
import dz.rgserver.model.Activite;
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
public class ActiviteRestService {
	
	@Autowired
	private ActiviteRepository activiteRepository;
	
	
	@RequestMapping(value="/activites", method = RequestMethod.GET)
	public List<Activite> getAllInstituions(){
	
		return activiteRepository.findAll();
	}
	
	
	
	@RequestMapping(value="/activites/{id}", method = RequestMethod.GET)
	public Activite getOneInstituion(@PathVariable long id ){
	
		return activiteRepository.findById(id).get();
	}
	
	

	@RequestMapping(value="/activites", method = RequestMethod.POST)
	public Activite saveActivite(@RequestBody Activite activite ){
	
		return activiteRepository.save(activite);
	}
	
	
	@RequestMapping(value="/activites/{id}", method = RequestMethod.DELETE)
	public  boolean deleteActivite(@PathVariable long id ){
	
		activiteRepository.deleteById(id);
		return true;
	}
	
	
	
	@RequestMapping(value="/activites/{id}", method = RequestMethod.PUT)
	public Activite updateActivite(@PathVariable long id ,@RequestBody Activite activite ){
	
		activite.setId_activite(id);
		return activiteRepository.save(activite);
	}
	

	@RequestMapping(value="/chercherActivites", method = RequestMethod.GET)
	public Page<Activite> chercherActivites(
			@RequestParam(name="mc",defaultValue = "") String mc, 
			@RequestParam(name="page",defaultValue = "0") int page, 
			@RequestParam(name="size",defaultValue = "5") int size){
	        
		return activiteRepository.chercherActivites("%"+mc+"%", new PageRequest(page, size));
	}
	
	
}
