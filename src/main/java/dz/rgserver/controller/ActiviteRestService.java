package dz.rgserver.controller;

import java.util.ArrayList;
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
	public List<Activite> getAllActivities(){
	
		return activiteRepository.findAll();
	}
	
	@RequestMapping(value="/activites/{id}", method = RequestMethod.GET)
	public Activite getOneActivite(@PathVariable long id ){
	
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
	
		activite.setId(id);
		return activiteRepository.save(activite);
	}
		
//recherche par mot clé 
	@RequestMapping(value="/chercherActivites", method = RequestMethod.GET)
	public Page<Activite> chercherActivites(
			@RequestParam(name="mc",defaultValue = "") String mc, 
			@RequestParam(name="page",defaultValue = "0") int page, 
			@RequestParam(name="size",defaultValue = "5") int size){
	        
		return activiteRepository.chercherActivites("%"+mc+"%", new PageRequest(page, size));
	}
//recherche par type d'activité 
	
	@RequestMapping(value="/chercherActiviteParType",method=RequestMethod.GET)
	public Page<Activite> chercherActiviteParType(
			@RequestParam(name="type",defaultValue = "") String type,
			@RequestParam(name="page",defaultValue = "0") int page, 
			@RequestParam(name="size",defaultValue = "5") int size
			
			){
		return activiteRepository.chercherActiviteParType("%"+type+"%", new PageRequest(page, size));
		
		}
//rechrche par domaine

	@RequestMapping(value="/chercherActiviteParDomaine",method=RequestMethod.GET)
	public Page<Activite> chercherActiviteParDomaine(
			@RequestParam(name="domaine",defaultValue = "") String domaine,
			@RequestParam(name="page",defaultValue = "0") int page, 
			@RequestParam(name="size",defaultValue = "5") int size){
		
		return activiteRepository.chercherActiviteParDomaine("%"+domaine+"%", new PageRequest(page, size));

		}
	
	//recherche par localisation
		@RequestMapping(value="/chercherActiviteParLocalisation",method=RequestMethod.GET)
		public Page<Activite> chercherActiviteParLocalisation(
				@RequestParam(name="localisation",defaultValue = "")String localisation,
				@RequestParam(name="page",defaultValue = "0") int page, 
				@RequestParam(name="size",defaultValue = "5") int size
				) {
			return activiteRepository.chercherActiviteParLocalisation("%"+localisation+"%", new PageRequest(page, size));

			
			}
	
				
		@RequestMapping(value="/getAllProjects",method=RequestMethod.GET)
		public List<Activite> getAllProjects( 	@RequestParam  String annee) {
			
		List<Activite> listePRojet =new ArrayList<Activite> () ;
		List<Activite> listActivite=getAllActivities();
		
		for (Activite activite : listActivite) {
			if(activite.getType().equals("project")) {
				String dateString = activite.getDate_debut().toString();
				if(dateString.contains(annee)) {
				listePRojet.add(activite);
				}
			}
		}
		return listePRojet;
				
}
		@RequestMapping(value="/getAllEvents/{annee}",method=RequestMethod.GET)
		public List<Activite> getAllEvents(
				@PathVariable  String annee) {
			
		List<Activite> listeEvents =new ArrayList<Activite> () ;
		List<Activite> listActivite=getAllActivities();
		
		
		for (Activite activite : listActivite) {
			 
			if(activite.getType().equals("event")) {
				String dateString = activite.getDate_debut().toString();
				if(dateString.contains(annee)) {
				listeEvents.add(activite);
				}
				}
			
			
		}
		return listeEvents;
				
}

}