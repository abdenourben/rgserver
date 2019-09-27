package dz.rgserver.controller;

import java.util.List;
import dz.rgserver.dao.InstitutionRepository;
import dz.rgserver.model.Institution;
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
public class InstitutionRestService {
	
	@Autowired
	private InstitutionRepository institutionRepository;
	
	
	@RequestMapping(value="/institutions", method = RequestMethod.GET)
	public List<Institution> getAllInstituions(){
	
		return institutionRepository.findAll();
	}
	
	@RequestMapping(value="/institutions/{id}", method = RequestMethod.GET)
	public Institution getOneInstituion(@PathVariable long id ){
	
		return institutionRepository.findById(id).get();
	}
	
	@RequestMapping(value="/institutions", method = RequestMethod.POST)
	public Institution saveInstituion(@RequestBody Institution institution ){
		return institutionRepository.save(institution);
	}
	
	@RequestMapping(value="/institutions/{id}", method = RequestMethod.DELETE)
	public  boolean deleteInstituion(@PathVariable long id ){
		institutionRepository.deleteById(id);
		return true;
	}

	@RequestMapping(value="/institutions/{id}", method = RequestMethod.PUT)
	public Institution updateInstituion(@PathVariable long id ,@RequestBody Institution institution ){
	
		institution.setId(id);
		return institutionRepository.save(institution);
	}

	@RequestMapping(value="/chercherInstitutionsNom", method = RequestMethod.GET)
	public Page<Institution> chercherInstitutionsNom(
			@RequestParam(name="mc",defaultValue = "") String mc, 
			@RequestParam(name="page",defaultValue = "0") int page, 
			@RequestParam(name="size",defaultValue = "5") int size){
	        
		return institutionRepository.chercherInstitutionsNom("%"+mc+"%", new PageRequest(page, size));
	}
	
	//recherche institution par raison sociale 
			@RequestMapping(value="/chercherInstitutionRaison",method=RequestMethod.GET)
			public Page<Institution>  chercherInstitutionRaison(
					@RequestParam(name="mc",defaultValue = "")String mc,
					@RequestParam(name="page",defaultValue = "0") int page, 
					@RequestParam(name="size",defaultValue = "5") int size
					) {
			 
	
				return institutionRepository.chercherInstitutionRaison("%"+mc+"%", new PageRequest(page, size));
				}
	
	//recherche institution par nature 
			@RequestMapping(value="/chercherInstitutionstatut",method=RequestMethod.GET)
			public Page<Institution> chercherInstitutionstatut(
					@RequestParam(name="mc",defaultValue = "")String mc,
					@RequestParam(name="page",defaultValue = "0") int page, 
					@RequestParam(name="size",defaultValue = "5") int size
					) {
			 
				return institutionRepository.chercherInstitutionstatut("%"+mc+"%", new PageRequest(page, size));
				}
	
	//recherche institution par categorie
			@RequestMapping(value="/chercherInstitutionCategorie",method=RequestMethod.GET)
			public Page<Institution> chercherInstitutionCategorie(
					@RequestParam(name="mc",defaultValue = "")String mc,
					@RequestParam(name="page",defaultValue = "0") int page, 
					@RequestParam(name="size",defaultValue = "5") int size
					) {
			 
				return institutionRepository.chercherInstitutionCategorie("%"+mc+"%", new PageRequest(page, size));
				}
			
	//recherche institution par secteurActivite
			
			@RequestMapping(value="/chercherInstitutionSecteur",method=RequestMethod.GET)
			public Page<Institution> chercherInstitutionSecteur(
					@RequestParam(name="mc",defaultValue = "")String mc,
					@RequestParam(name="page",defaultValue = "0") int page, 
					@RequestParam(name="size",defaultValue = "5") int size
					) {
				return institutionRepository.chercherInstitutionSecteur("%"+mc+"%", new PageRequest(page, size));
				
			}
			
	//recherche institution par type 
			@RequestMapping(value="/chercherInstitutionType",method=RequestMethod.GET)
			public Page<Institution>chercherInstitutionType(
					@RequestParam(name="mc",defaultValue = "")String mc,
					@RequestParam(name="page",defaultValue = "0") int page, 
					@RequestParam(name="size",defaultValue = "5") int size
					) {
			 
				return institutionRepository.chercherInstitutionType("%"+mc+"%", new PageRequest(page, size));
}		
			
	//recherche institution par type implication APA
			@RequestMapping(value="/chercherInstitutionTypeImplication",method=RequestMethod.GET)
			public Page<Institution>chercherInstitutionTypeImplication(
					@RequestParam(name="mc",defaultValue = "")String mc,
					@RequestParam(name="page",defaultValue = "0") int page, 
					@RequestParam(name="size",defaultValue = "5") int size
					) {
			 
				return institutionRepository.chercherInstitutionTypeImplication("%"+mc+"%", new PageRequest(page, size));
}
			@RequestMapping(value = "/institutions/find/{id}", method = RequestMethod.GET)
			public Institution find(@PathVariable long id) {
				return institutionRepository.findByRgId(id);  
			}
			
			
			
}