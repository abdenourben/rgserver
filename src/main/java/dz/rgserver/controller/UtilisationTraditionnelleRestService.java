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

import dz.rgserver.dao.UtilisationCommercialeRepository;
import dz.rgserver.model.UtilisationCommerciale;

@RestController
@CrossOrigin("*")
public class UtilisationTraditionnelleRestService  {

@Autowired
private UtilisationCommercialeRepository utilisationCommercialeRepository;


@RequestMapping(value="/utilisationCommerciales", method = RequestMethod.GET)
public List<UtilisationCommerciale> getAllUtilisationCommerciales(){

return utilisationCommercialeRepository.findAll();
}



@RequestMapping(value="/utilisationCommerciales/{id}", method = RequestMethod.GET)
public UtilisationCommerciale getOneUtilisationCommerciale(@PathVariable long id ){

return utilisationCommercialeRepository.findById(id).get();
}



@RequestMapping(value="/utilisationCommerciales", method = RequestMethod.POST)
public UtilisationCommerciale saveInstituion(@RequestBody UtilisationCommerciale utilisationCommerciale ){

return utilisationCommercialeRepository.save(utilisationCommerciale);
}


@RequestMapping(value="/utilisationCommerciales/{id}", method = RequestMethod.DELETE)
public  boolean deleteUtilisationCommerciale(@PathVariable long id ){

utilisationCommercialeRepository.deleteById(id);
return true;
}

@RequestMapping(value="/utilisationCommerciales/{id}", method = RequestMethod.PUT)
public UtilisationCommerciale updateInstituion(@PathVariable long id ,@RequestBody UtilisationCommerciale utilisationCommerciale ){

utilisationCommerciale.setId_use_commercile(id);
return utilisationCommercialeRepository.save(utilisationCommerciale);
}

@RequestMapping(value="/chercherUtilisationCommerciales", method = RequestMethod.GET)
public Page<UtilisationCommerciale> chercherUtilisationCommerciales(
@RequestParam(name="mc",defaultValue = "") String mc, 
@RequestParam(name="page",defaultValue = "0") int page, 
@RequestParam(name="size",defaultValue = "5") int size){
       
return utilisationCommercialeRepository.chercherUtilisationCommerciales("%"+mc+"%", new PageRequest(page, size));
}

}

