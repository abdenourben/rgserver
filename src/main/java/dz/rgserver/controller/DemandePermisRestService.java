package dz.rgserver.controller;

import java.util.List;
import dz.rgserver.dao.DemandePermisRepository;
import dz.rgserver.model.DemandePermis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class DemandePermisRestService {
	
	@Autowired
	private DemandePermisRepository demandePermisRepository;
	
	
	@RequestMapping(value="/demandePermis", method = RequestMethod.GET)
	public List<DemandePermis> getAllDemandePermis(){
	
		return demandePermisRepository.findAll();
	}
	
	
	
	@RequestMapping(value="/demandePermis/{id}", method = RequestMethod.GET)
	public DemandePermis getOneDemandePermis(@PathVariable long id ){
	
		return demandePermisRepository.findById(id).get();
	}
	
	
// sauvegarder une demande de permis envoyé par mail
	@RequestMapping(value="/demandePermis", method = RequestMethod.POST)
	public DemandePermis saveDemandePermis(@RequestBody DemandePermis demandePermis ){
		demandePermis.setEtat("Brouillon");
		return demandePermisRepository.save(demandePermis);
	}
	
	@RequestMapping(value="/demandePermis/{id}", method = RequestMethod.DELETE)
	public  boolean deleteDemandePermis(@PathVariable long id ){
	
		demandePermisRepository.deleteById(id);
		return true;
	}
	
	@RequestMapping(value="/demandePermis/{id}", method = RequestMethod.PUT)
	public DemandePermis updateDemandePermis(@PathVariable long id ,@RequestBody DemandePermis demandePermis ){
	
		demandePermis.setId_demande(id);
		return demandePermisRepository.save(demandePermis);
	}
	
	@RequestMapping(value="/chercherDemandePermis", method = RequestMethod.GET)
	public Page<DemandePermis> chercherDemandePermis(
			@RequestParam(name="mc",defaultValue = "") String mc, 
			@RequestParam(name="page",defaultValue = "0") int page, 
			@RequestParam(name="size",defaultValue = "5") int size){
	        
		return demandePermisRepository.chercherDemandePermis("%"+mc+"%", new PageRequest(page, size));
	}
	/****Les trois fonctions du workflow:
     *autoriserDemandePermis, 
     *nePasAutoriserDemandePermis,
     *mettreEnAttenteDemandePermis
*****/
@RequestMapping(value="/autoriserDemandePermis/{id}", method = RequestMethod.POST)
public DemandePermis autoriserDemandePermis(@PathVariable("id") long id ){
 DemandePermis demandePermis= demandePermisRepository.findById(id).get();
 demandePermis.setEtat("autorisé");
 return demandePermisRepository.save(demandePermis);
}
	
	@RequestMapping(value="/nePasAutoriserDemandePermis/{id}", method = RequestMethod.POST)
	public DemandePermis nePasAutoriserDemandePermis(@PathVariable long id ){
		DemandePermis demandePermis= demandePermisRepository.findById(id).get();
		 demandePermis.setEtat("non autorisé");
		 return demandePermisRepository.save(demandePermis);
	}
	

	
	@RequestMapping(value="/mettreEnAttenteDemandePermis/{id}", method = RequestMethod.POST)
	public void mettreEnAttenteDemandePermis(@PathVariable long id ) {
		DemandePermis demandePermis= demandePermisRepository.findById(id).get();
		 demandePermis.setEtat("en attente");
	     demandePermisRepository.save(demandePermis);
	}
	
	
	//la fonction d'envoie par mail

}
