package dz.rgserver.controller;

import java.util.ArrayList;
import java.util.List;
import dz.rgserver.dao.RessourceGenetiqueRepository;
import dz.rgserver.model.Activite;
import dz.rgserver.model.Classification;
import dz.rgserver.model.Region;
import dz.rgserver.model.RessourceGenetique;
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
public class RessourceGenetiqueRestService {

@Autowired
private RessourceGenetiqueRepository ressourceGenetiqueRepository;


@RequestMapping(value="/ressourceGenetiques", method = RequestMethod.GET)
public List<RessourceGenetique> getAllRessourceGenetiques(){

return ressourceGenetiqueRepository.findAll();
}



@RequestMapping(value="/ressourceGenetiques/{id}", method = RequestMethod.GET)
public RessourceGenetique getOneRessourceGenetique(@PathVariable long id ){

return ressourceGenetiqueRepository.findById(id).get();
}



@RequestMapping(value="/ressourceGenetiques", method = RequestMethod.POST)
public RessourceGenetique saveInstituion(@RequestBody RessourceGenetique ressourceGenetique ){

return ressourceGenetiqueRepository.save(ressourceGenetique);
}


@RequestMapping(value="/ressourceGenetiques/{id}", method = RequestMethod.DELETE)
public  boolean deleteRessourceGenetique(@PathVariable long id ){

ressourceGenetiqueRepository.deleteById(id);
return true;
}



@RequestMapping(value="/ressourceGenetiques/{id}", method = RequestMethod.PUT)
public RessourceGenetique updateInstituion(@PathVariable long id ,@RequestBody RessourceGenetique ressourceGenetique ){

ressourceGenetique.setId_ressource(id);
return ressourceGenetiqueRepository.save(ressourceGenetique);
}

//recherche RG par designation_Fr
@RequestMapping(value="/chercherRessourceGenetiques", method = RequestMethod.GET)
public Page<RessourceGenetique> chercherRessourceGenetiques(
@RequestParam(name="mc",defaultValue = "") String mc, 
@RequestParam(name="page",defaultValue = "0") int page, 
@RequestParam(name="size",defaultValue = "5") int size){
       
return ressourceGenetiqueRepository.chercherRessourceGenetiques("%"+mc+"%", new PageRequest(page, size));
}
//recherche RG par nom_commun
@RequestMapping(value="/chercherRessourceGenetiquesNomCommun",method=RequestMethod.GET)
public Page<RessourceGenetique> chercherRessourceGenetiquesNomCommun(
@RequestParam(name="nom_commun",defaultValue = "")String nom_commun,
@RequestParam(name="page",defaultValue = "0") int page, 
@RequestParam(name="size",defaultValue = "5") int size
		) {

	return ressourceGenetiqueRepository.chercherRessourceGenetiquesNomCommun("%"+nom_commun+"%", new PageRequest(page, size));
	}

//recherche RG par nom_scientifique
@RequestMapping(value="/chercherRessourceGenetiquesNomScientifique",method=RequestMethod.GET)
public Page<RessourceGenetique> chercherRessourceGenetiquesNomScientifique(
@RequestParam(name="nom_scientifique",defaultValue = "")String nom_scientifique,
@RequestParam(name="page",defaultValue = "0") int page, 
@RequestParam(name="size",defaultValue = "5") int size
) {

	return ressourceGenetiqueRepository.chercherRessourceGenetiquesNomScientifique("%"+nom_scientifique+"%", new PageRequest(page, size));
	}
//recherche RG par environnement

@RequestMapping(value="/chercherRessourceGenetiquesParEnvironnement",method=RequestMethod.GET)
public Page<RessourceGenetique> chercherRessourceGenetiquesParEnvironnement(
@RequestParam(name="environnement",defaultValue = "")String environnement,
@RequestParam(name="page",defaultValue = "0") int page, 
@RequestParam(name="size",defaultValue = "5") int size) {

	return ressourceGenetiqueRepository.chercherRessourceGenetiquesParEnvironnement("%"+environnement+"%", new PageRequest(page, size));
}
//recherche de la liste des regions associé à une RG_FR

@RequestMapping(value="/chercherRG_RegionsFR", method = RequestMethod.GET)
public Page<Region> chercherRG_RegionsFR(
@RequestParam(name="designation_Fr",defaultValue = "") String designation_Fr,
@RequestParam(name="page",defaultValue = "0") int page, 
@RequestParam(name="size",defaultValue = "5") int size)
{	
	return ressourceGenetiqueRepository.chercherRG_RegionsFR("%"+designation_Fr+"%", new PageRequest(page, size));
}
	//recherche de la liste des regions associé à une RG_Ar


@RequestMapping(value="/chercherRG_RegionsAr", method = RequestMethod.GET)
public Page<Region> chercherRG_RegionsAr(
@RequestParam(name="désignation_Ar",defaultValue = "") String désignation_Ar,
@RequestParam(name="page",defaultValue = "0") int page, 
@RequestParam(name="size",defaultValue = "5") int size)
{
	return ressourceGenetiqueRepository.chercherRG_RegionsAr("%"+désignation_Ar+"%", new PageRequest(page, size));
	}
}
