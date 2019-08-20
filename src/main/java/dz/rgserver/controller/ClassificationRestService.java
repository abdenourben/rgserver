package dz.rgserver.controller;

import java.util.List;
import dz.rgserver.dao.ClassificationRepository;
import dz.rgserver.model.Classification;
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
public class ClassificationRestService {
	
	@Autowired
	private ClassificationRepository classificationRepository;
	
	
	@RequestMapping(value="/classifications", method = RequestMethod.GET)
	public List<Classification> getAllClassifications(){
	
		return classificationRepository.findAll();
	}
	
	
	
	@RequestMapping(value="/classifications/{id}", method = RequestMethod.GET)
	public Classification getOneClassification(@PathVariable long id ){
	
		return classificationRepository.findById(id).get();
	}
	
	

	@RequestMapping(value="/classifications", method = RequestMethod.POST)
	public Classification saveClassification(@RequestBody Classification classification ){
	
		return classificationRepository.save(classification);
	}
	
	
	@RequestMapping(value="/classifications/{id}", method = RequestMethod.DELETE)
	public  boolean deleteClassification(@PathVariable long id ){
	
		classificationRepository.deleteById(id);
		return true;
	}
	
	
	
	@RequestMapping(value="/classifications/{id}", method = RequestMethod.PUT)
	public Classification updateClassification(@PathVariable long id ,@RequestBody Classification classification ){
	
		classification.setId_classification(id);
		return classificationRepository.save(classification);
	}
	
	
	

	
	@RequestMapping(value="/chercherClassifications", method = RequestMethod.GET)
	public Page<Classification> chercherClassifications(
			@RequestParam(name="mc",defaultValue = "") String mc, 
			@RequestParam(name="page",defaultValue = "0") int page, 
			@RequestParam(name="size",defaultValue = "5") int size){
	        
		return classificationRepository.chercherClassifications("%"+mc+"%", new PageRequest(page, size));
	}
	
	
}

