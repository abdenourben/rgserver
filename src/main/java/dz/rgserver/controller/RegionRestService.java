package dz.rgserver.controller;

import java.util.ArrayList;
import java.util.List;
import dz.rgserver.dao.RegionRepository;
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
public class RegionRestService {

@Autowired
private RegionRepository regionRepository;


@RequestMapping(value="/regions", method = RequestMethod.GET)
public List<Region> getAllRegions(){

return regionRepository.findAll();
}



@RequestMapping(value="/regions/{id}", method = RequestMethod.GET)
public Region getOneInstituion(@PathVariable long id ){

return regionRepository.findById(id).get();
}



@RequestMapping(value="/regions", method = RequestMethod.POST)
public Region saveRegion(@RequestBody Region region ){

return regionRepository.save(region);
}


@RequestMapping(value="/regions/{id}", method = RequestMethod.DELETE)
public  boolean deleteRegion(@PathVariable long id ){

regionRepository.deleteById(id);
return true;
}



@RequestMapping(value="/regions/{id}", method = RequestMethod.PUT)
public Region updateRegion(@PathVariable long id ,@RequestBody Region region ){

region.setId_region(id);
return regionRepository.save(region);
}




//rechercher une region par designation
@RequestMapping(value="/chercherRegions", method = RequestMethod.GET)
public Page<Region> chercherRegions(
@RequestParam(name="mc",defaultValue = "") String mc, 
@RequestParam(name="page",defaultValue = "0") int page, 
@RequestParam(name="size",defaultValue = "5") int size){
       
return regionRepository.chercherRegions("%"+mc+"%", new PageRequest(page, size));
}

//recherche de la liste des RG associé à une region(wilaya)

@RequestMapping(value="/chercherWilaya_RG", method = RequestMethod.GET)
public Page<RessourceGenetique> chercherWilaya_RG(
@RequestParam(name="wilaya",defaultValue = "") String wilaya,
@RequestParam(name="page",defaultValue = "0") int page, 
@RequestParam(name="size",defaultValue = "5") int size
)
{
	return regionRepository.chercherWilaya_RG("%"+wilaya+"%", new PageRequest(page, size));
}


}
