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
import dz.rgserver.dao.TaxonomieRepository;
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
	public Taxonomie updateTaxonomie(@PathVariable long id ,@RequestBody Taxonomie taxonomie ){
	
		taxonomie.setId(id);
		return taxonomieRepository.save(taxonomie);
	}

	//Recherche par classe
	@RequestMapping(value="/chercherTaxonomieClasse", method = RequestMethod.GET)
	 public Page<Taxonomie> chercherTaxonomieClasse(
			@RequestParam(name="mc",defaultValue = "") String mc, 
			@RequestParam(name="page",defaultValue = "0") int page, 
			@RequestParam(name="size",defaultValue = "5") int size){
	        
		return taxonomieRepository.chercherTaxonomieClasse("%"+mc+"%", new PageRequest(page, size));
	}

	//Recherche par ordre
		@RequestMapping(value="/chercherTaxonomieOrdre", method = RequestMethod.GET)
		public Page<Taxonomie> chercherTaxonomieOrdre(
				@RequestParam(name="mc",defaultValue = "") String mc, 
				@RequestParam(name="page",defaultValue = "0") int page, 
				@RequestParam(name="size",defaultValue = "5") int size){
		        
			return taxonomieRepository.chercherTaxonomieOrdre("%"+mc+"%", new PageRequest(page, size));
		}

		@RequestMapping(value="/chercherTaxonomieFamille", method = RequestMethod.GET)
		public Page<Taxonomie> chercherTaxonomieFamille(
				@RequestParam(name="mc",defaultValue = "") String mc, 
				@RequestParam(name="page",defaultValue = "0") int page, 
				@RequestParam(name="size",defaultValue = "5") int size){
		        
			return taxonomieRepository.chercherTaxonomieFamille("%"+mc+"%", new PageRequest(page, size));
		}

		@RequestMapping(value="/chercherTaxonomieGenre", method = RequestMethod.GET)
		public Page<Taxonomie> chercherTaxonomieGenre(
				@RequestParam(name="mc",defaultValue = "") String mc, 
				@RequestParam(name="page",defaultValue = "0") int page, 
				@RequestParam(name="size",defaultValue = "5") int size){
		        
			return taxonomieRepository.chercherTaxonomieGenre("%"+mc+"%", new PageRequest(page, size));
		}

		@RequestMapping(value="/chercherTaxonomieEspece", method = RequestMethod.GET)
		public Page<Taxonomie> chercherTaxonomieEspece(
				@RequestParam(name="mc",defaultValue = "") String mc, 
				@RequestParam(name="page",defaultValue = "0") int page, 
				@RequestParam(name="size",defaultValue = "5") int size){
		        
			return taxonomieRepository.chercherTaxonomieEspece("%"+mc+"%", new PageRequest(page, size));
		}

}
