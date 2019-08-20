package dz.rgserver.controller;

import java.util.List;
import dz.rgserver.dao.DemandePermisRepository;
import dz.rgserver.model.DemandePermis;
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
	
	

	@RequestMapping(value="/demandePermis", method = RequestMethod.POST)
	public DemandePermis saveDemandePermis(@RequestBody DemandePermis demandePermis ){
	
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
	
	
}
