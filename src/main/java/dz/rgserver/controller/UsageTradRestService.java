package dz.rgserver.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dz.rgserver.dao.UsageTradRepository;
import dz.rgserver.model.UsageTrad;

@RestController
@CrossOrigin("*")
public class UsageTradRestService {

	@Autowired
	private UsageTradRepository usagTradRepository;
	
	@RequestMapping(value = "/usage-trad", method = RequestMethod.GET)
	public List<UsageTrad> listUsageTrad() {
		return usagTradRepository.findAll(); 
	}
	
	@RequestMapping(value = "/usage-trad", method = RequestMethod.POST)
	public UsageTrad saveUsageTrad(@RequestBody UsageTrad usageTrad) {
		return usagTradRepository.save(usageTrad); 
	}
	
	@RequestMapping(value = "/usage-trad/find/{id}", method = RequestMethod.GET)
	public List<UsageTrad> find(@PathVariable long id) {
		return usagTradRepository.findByRgId(id); 
	}
}
