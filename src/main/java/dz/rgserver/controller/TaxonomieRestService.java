package dz.rgserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dz.rgserver.dao.TaxonomieRepository;
import dz.rgserver.model.Institution;
import dz.rgserver.model.Taxonomie;

@RestController
@CrossOrigin("*")
public class TaxonomieRestService {
	
	@Autowired
	private TaxonomieRepository taxonomieRepository;
	
	@RequestMapping(value="/taxonomies", method = RequestMethod.GET)
	public List<Taxonomie> getAllTaxonomies(){
		return taxonomieRepository.findAll();
	}
	
	
	@RequestMapping(value="/taxonomies/{id}", method = RequestMethod.GET)
	public Taxonomie getOneTaxonomie(@PathVariable long id ){
	
		return taxonomieRepository.findById(id).get();
	}
	
	
	@RequestMapping(value="/taxonomies", method = RequestMethod.POST)
	public Taxonomie saveTaxonomie(@RequestBody Taxonomie taxonomie ){
	
		return taxonomieRepository.save(taxonomie);
	}
	
	
	@RequestMapping(value="/taxonomies/{id}", method = RequestMethod.DELETE)
	public  boolean deleteTaxonomie(@PathVariable long id ){
	
		taxonomieRepository.deleteById(id);
		return true;
	}
	
	@RequestMapping(value="/taxonomies/{id}", method = RequestMethod.PUT)
	public Taxonomie updateTaxonomie(@PathVariable long id, @RequestBody Taxonomie taxonomie ){
			return taxonomieRepository.save(taxonomie);
	}
	
	 @RequestMapping(value = "/taxonomies/find/{id}", method = RequestMethod.GET)
		public Taxonomie find(@PathVariable long id) {
			return taxonomieRepository.findByRgId(id);  
		}


}
