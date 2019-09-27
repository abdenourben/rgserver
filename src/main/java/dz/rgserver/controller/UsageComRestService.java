package dz.rgserver.controller;

import java.util.List;
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

import dz.rgserver.dao.UsageComRepository;
import dz.rgserver.model.UsageCom;

@RestController
@CrossOrigin("*")
public class UsageComRestService {
	
	@Autowired
	private UsageComRepository usageComRepository;
	
	@RequestMapping(value = "/usage-com", method = RequestMethod.GET)
	public List<UsageCom> listUsageCom() {
		return usageComRepository.findAll(); 
	}
	
	@RequestMapping(value="/utilisationCommerciales/{id}", method = RequestMethod.GET)
	public UsageCom getOneUtilisationCommerciale(@PathVariable long id ){
	
		return usageComRepository.findById(id).get();
	}

	@RequestMapping(value = "/usage-com", method = RequestMethod.POST)
	public UsageCom saveUsageCom(@RequestBody UsageCom usageCom) {
		return usageComRepository.save(usageCom); 
	}
	
	@RequestMapping(value="/utilisationCommerciales/{id}", method = RequestMethod.DELETE)
	public  boolean deleteUtilisationCommerciale(@PathVariable long id ){
	
		usageComRepository.deleteById(id);
		return true;
	}
	
	@RequestMapping(value="/utilisationCommerciales/{id}", method = RequestMethod.PUT)
	public UsageCom UsageComUpdate(@PathVariable long id ,@RequestBody UsageCom utilisationCommerciale ){
	
		utilisationCommerciale.setId(id);
		return usageComRepository.save(utilisationCommerciale);
	}

	@RequestMapping(value="/chercherUtilisationCommerciales", method = RequestMethod.GET)
	public Page<UsageCom> chercherUtilisationCommerciales(
			@RequestParam(name="mc",defaultValue = "") String mc, 
			@RequestParam(name="page",defaultValue = "0") int page, 
			@RequestParam(name="size",defaultValue = "5") int size){
	        
		return usageComRepository.chercherUtilisationCommerciales("%"+mc+"%", new PageRequest(page, size));
	}
	
	@RequestMapping(value = "/usage-com/find/{id}", method = RequestMethod.GET)
	public List<UsageCom> find(@PathVariable long id) {
		return usageComRepository.findByRgId(id); 
	}
	
	
}

