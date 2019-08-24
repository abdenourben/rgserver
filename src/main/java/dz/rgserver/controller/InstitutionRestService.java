package dz.rgserver.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import dz.rgserver.dao.InstitutionRepository;
import dz.rgserver.model.Activite;
import dz.rgserver.model.Classification;
import dz.rgserver.model.Institution;
import dz.rgserver.model.RessourceGenetique;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;
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

@RequestMapping(value="/chercherInstitutions", method = RequestMethod.GET)
public Page<Institution> chercherInstitutions(
@RequestParam(name="mc",defaultValue = "") String mc, 
@RequestParam(name="page",defaultValue = "0") int page, 
@RequestParam(name="size",defaultValue = "5") int size){
       
return institutionRepository.chercherInstitutions("%"+mc+"%", new PageRequest(page, size));
}

//recherche institution par raison sociale 

@RequestMapping(value="/chercherInstitutionParRaison", method = RequestMethod.GET)
public Page<Institution> chercherInstitutionParRaison(
@RequestParam(name="raisonSociale",defaultValue = "") String raisonSociale, 
@RequestParam(name="page",defaultValue = "0") int page, 
@RequestParam(name="size",defaultValue = "5") int size){
       
return institutionRepository.chercherInstitutionParRaison("%"+raisonSociale+"%", new PageRequest(page, size));
}

//recherche institution par nature 

@RequestMapping(value="/chercherInstitutionParNature", method = RequestMethod.GET)
public Page<Institution> chercherInstitutionParNature(
@RequestParam(name="natureEtabelissement",defaultValue = "") String natureEtabelissement, 
@RequestParam(name="page",defaultValue = "0") int page, 
@RequestParam(name="size",defaultValue = "5") int size){
       
return institutionRepository.chercherInstitutionParNature("%"+natureEtabelissement+"%", new PageRequest(page, size));
}
//recherche institution par secteurActivite


@RequestMapping(value="/chercherInstitutionParSecteur", method = RequestMethod.GET)
public Page<Institution> chercherInstitutionParSecteur(
@RequestParam(name="secteurActivite",defaultValue = "") String secteurActivite, 
@RequestParam(name="page",defaultValue = "0") int page, 
@RequestParam(name="size",defaultValue = "5") int size){
       
return institutionRepository.chercherInstitutionParSecteur("%"+secteurActivite+"%", new PageRequest(page, size));
}

//recherche institution par date d'implication APA


@RequestMapping(value="/chercherInstitutionParAnnéeAPA", method = RequestMethod.GET)
public Page<Institution> chercherInstitutionParAnnéeAPA(
		
		@DateTimeFormat(pattern = "dd.MM.yyyy") Date anneeImplicationApa,
		@RequestParam(name="page",defaultValue = "0") int page, 
		@RequestParam(name="size",defaultValue = "5") int size
		){
       
return institutionRepository.chercherInstitutionParAnnéeAPA(anneeImplicationApa, new PageRequest(page, size));
}

//recherche de la liste des RG associé à une institution


@RequestMapping(value="/chercherInstitution_RG", method = RequestMethod.GET)
public Page<RessourceGenetique> chercherInstitution_RG(
@RequestParam(name="nom",defaultValue = "") String nom, 
@RequestParam(name="page",defaultValue = "0") int page, 
@RequestParam(name="size",defaultValue = "5") int size){
       
return institutionRepository.chercherInstitution_RG("%"+nom+"%", new PageRequest(page, size));
}

}
