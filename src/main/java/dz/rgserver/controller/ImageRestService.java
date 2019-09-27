package dz.rgserver.controller;

import java.util.List;
import dz.rgserver.dao.ImageRepository;
import dz.rgserver.model.Image;
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
public class ImageRestService {
	
	@Autowired
	private ImageRepository imageRepository;
	
	@RequestMapping(value="/images", method = RequestMethod.GET)
	
	public List<Image> getAllImages(){
	
		return imageRepository.findAll();
	}
	
	@RequestMapping(value="/images/{id}", method = RequestMethod.GET)
	public Image getOneImage(@PathVariable long id ){
	
		return imageRepository.findById(id).get();
	}

	@RequestMapping(value="/images", method = RequestMethod.POST)
	public Image saveImage(@RequestBody Image image ){
	
		return imageRepository.save(image);
	}
	
	@RequestMapping(value="/images/{id}", method = RequestMethod.DELETE)
	public  boolean deleteImage(@PathVariable long id ){
	
		imageRepository.deleteById(id);
		return true;
	}
	
	@RequestMapping(value="/images/{id}", method = RequestMethod.PUT)
	public Image updateImage(@PathVariable long id ,@RequestBody Image image ){
	
		image.setId(id);
		return imageRepository.save(image);
	}
	
	@RequestMapping(value="/chercherImagesTitre", method = RequestMethod.GET)
	public Page<Image> chercherImagesTitre(
			@RequestParam(name="mc",defaultValue = "") String titre, 
			@RequestParam(name="page",defaultValue = "0") int page, 
			@RequestParam(name="size",defaultValue = "5") int size){
	        
		return imageRepository.chercherImagesTitre("%"+titre+"%", new PageRequest(page, size));
	}
	
	@RequestMapping(value="/chercherImagesType", method = RequestMethod.GET)
	public Page<Image> chercherImagesType(
			@RequestParam(name="mc",defaultValue = "") String type, 
			@RequestParam(name="page",defaultValue = "0") int page, 
			@RequestParam(name="size",defaultValue = "5") int size){
	        
		return imageRepository.chercherImagesType("%"+type+"%", new PageRequest(page, size));
	}
	//@RequestMapping(value = "/images/find/{id}", method = RequestMethod.GET)
		//public List<Image> find(@PathVariable long id) {
			//return imageRepository.findByImageId(id); 
		//}
	
	
}
