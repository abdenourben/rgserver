package dz.rgserver.controller;

import java.util.ArrayList;
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
import dz.rgserver.model.RessourceGenetique;
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

taxonomie.setId_taxonomie(id);
return taxonomieRepository.save(taxonomie);
}

//Recherche par mot clé
@RequestMapping(value="/chercherTaxonomies", method = RequestMethod.GET)
public Page<Taxonomie> chercherTaxonomies(
@RequestParam(name="mc",defaultValue = "") String mc, 
@RequestParam(name="page",defaultValue = "0") int page, 
@RequestParam(name="size",defaultValue = "5") int size){
       
return taxonomieRepository.chercherTaxonomies("%"+mc+"%", new PageRequest(page, size));
}
//recherche de la liste des RG associé à une toxonomie_classe

@RequestMapping(value="/chercherTaxonomieClasse_RG", method = RequestMethod.GET)
public Page<RessourceGenetique> chercherTaxonomieClasse_RG(
@RequestParam(name="taxonomieClasse",defaultValue = "") String taxonomieClasse, 
@RequestParam(name="page",defaultValue = "0") int page, 
@RequestParam(name="size",defaultValue = "5") int size)
{
	return taxonomieRepository.chercherTaxonomieClasse_RG("%"+taxonomieClasse+"%", new PageRequest(page, size));

	}

//recherche de la liste des RG associé à une toxonomie_ordre

@RequestMapping(value="/chercherTaxonomieOrdre_RG", method = RequestMethod.GET)
public Page<RessourceGenetique> chercherTaxonomieOrdre_RG(
@RequestParam(name="taxonomieOrdre",defaultValue = "") String taxonomieOrdre, 
@RequestParam(name="page",defaultValue = "0") int page, 
@RequestParam(name="size",defaultValue = "5") int size)
{
	return taxonomieRepository.chercherTaxonomieOrdre_RG("%"+taxonomieOrdre+"%", new PageRequest(page, size));

	}
//recherche de la liste des RG associé à une toxonomie_famille

@RequestMapping(value="/chercherTaxonomieFamille_RG", method = RequestMethod.GET)
public Page<RessourceGenetique> chercherTaxonomieFamille_RG(
@RequestParam(name="taxonomieFamille",defaultValue = "") String taxonomieFamille, 
@RequestParam(name="page",defaultValue = "0") int page, 
@RequestParam(name="size",defaultValue = "5") int size)
{
	return taxonomieRepository.chercherTaxonomieFamille_RG("%"+taxonomieFamille+"%", new PageRequest(page, size));

	}

//recherche de la liste des RG associé à une toxonomie_genre

@RequestMapping(value="/chercherTaxonomieGenre_RG", method = RequestMethod.GET)
public Page<RessourceGenetique> chercherTaxonomieGenre_RG(
@RequestParam(name="taxonomieGenre",defaultValue = "") String taxonomieGenre, 
@RequestParam(name="page",defaultValue = "0") int page, 
@RequestParam(name="size",defaultValue = "5") int size)
{
	return taxonomieRepository.chercherTaxonomieGenre_RG("%"+taxonomieGenre+"%", new PageRequest(page, size));
	}

//recherche de la liste des RG associé à une toxonomie_espece

@RequestMapping(value="/chercherTaxonomieEspece_RG", method = RequestMethod.GET)
public Page<RessourceGenetique> chercherTaxonomieEspece_RG(
@RequestParam(name="taxonomieEspece",defaultValue = "") String taxonomieEspece, 
@RequestParam(name="page",defaultValue = "0") int page, 
@RequestParam(name="size",defaultValue = "5") int size)
{
	return taxonomieRepository.chercherTaxonomieEspece_RG("%"+taxonomieEspece+"%", new PageRequest(page, size));
	}

}