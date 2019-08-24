package dz.rgserver.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import dz.rgserver.dao.LoiRepository;
import dz.rgserver.model.Activite;
import dz.rgserver.model.Loi;
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
public class LoiRestService {

@Autowired
private LoiRepository loiRepository;


@RequestMapping(value="/lois", method = RequestMethod.GET)
public List<Loi> getAllLois(){

return loiRepository.findAll();
}



@RequestMapping(value="/lois/{id}", method = RequestMethod.GET)
public Loi getOneLoi(@PathVariable long id ){

return loiRepository.findById(id).get();
}



@RequestMapping(value="/lois", method = RequestMethod.POST)
public Loi saveLoi(@RequestBody Loi loi ){

return loiRepository.save(loi);
}


@RequestMapping(value="/lois/{id}", method = RequestMethod.DELETE)
public  boolean deleteLoi(@PathVariable long id ){

loiRepository.deleteById(id);
return true;
}



@RequestMapping(value="/lois/{id}", method = RequestMethod.PUT)
public Loi updateLoi(@PathVariable long id ,@RequestBody Loi loi ){

loi.setId_loi(id);
return loiRepository.save(loi);
}



//recherche loi par designation

@RequestMapping(value="/chercherLois", method = RequestMethod.GET)
public Page<Loi> chercherLois(
@RequestParam(name="mc",defaultValue = "") String mc, 
@RequestParam(name="page",defaultValue = "0") int page, 
@RequestParam(name="size",defaultValue = "5") int size){
       
return loiRepository.chercherLois("%"+mc+"%", new PageRequest(page, size));
}

//recherche loi par annee(apartir d'une date)
@RequestMapping(value="/chercherLoiParAnnee",method=RequestMethod.GET)
public Page<Loi> chercherLoiParAnnee(

@DateTimeFormat(pattern = "dd.MM.yyyy")Date anneeLoi,
@RequestParam(name="page",defaultValue = "0") int page, 
@RequestParam(name="size",defaultValue = "5") int size
		) {

return loiRepository.chercherLoiParAnnee(anneeLoi,new PageRequest(page, size));
}

}
