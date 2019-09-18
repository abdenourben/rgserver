package dz.rgserver.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping(value = "/usage-com", method = RequestMethod.POST)
	public UsageCom saveUsageCom(@RequestBody UsageCom usageCom) {
		return usageComRepository.save(usageCom); 
	}
	
	@RequestMapping(value = "/usage-com/find/{id}", method = RequestMethod.GET)
	public List<UsageCom> find(@PathVariable long id) {
		return usageComRepository.findByRgId(id); 
	}
	
}
