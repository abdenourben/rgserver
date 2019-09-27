package dz.rgserver.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dz.rgserver.dao.usagTradRepository;
import dz.rgserver.model.UsageTrad;

@RestController
@CrossOrigin("*")
public class UsageTradRestService {
	
	@Autowired
	private usagTradRepository usagTradRepository;
	
	@RequestMapping(value = "/usage-trad", method = RequestMethod.GET)
	public List<UsageTrad> listUsageTrad() {
		return usagTradRepository.findAll(); 
	}
	
	@RequestMapping(value="/utilisationTraditionnelles/{id}", method = RequestMethod.GET)
	public UsageTrad getOneUtilisationTraditionnelle(@PathVariable long id ){
	
		return usagTradRepository.findById(id).get();
	}

	@RequestMapping(value = "/usage-trad", method = RequestMethod.POST)
	public UsageTrad saveUsageTrad(@RequestBody UsageTrad usageTrad) {
		return usagTradRepository.save(usageTrad); 
	}
	
	@RequestMapping(value="/utilisationTraditionnelles/{id}", method = RequestMethod.DELETE)
	public  boolean deleteUtilisationTraditionnelle(@PathVariable long id ){
	
		usagTradRepository.deleteById(id);
		return true;
	}
	
	@RequestMapping(value="/utilisationTraditionnelles/{id}", method = RequestMethod.PUT)
	public UsageTrad updateInstituion(@PathVariable long id ,@RequestBody UsageTrad utilisationTraditionnelle ){
	
		utilisationTraditionnelle.setId(id);
		return usagTradRepository.save(utilisationTraditionnelle);
	}
	@RequestMapping(value = "/usage-trad/find/{id}", method = RequestMethod.GET)
	public List<UsageTrad> find(@PathVariable long id) {
		return usagTradRepository.findByRgId(id); 
	}

}
