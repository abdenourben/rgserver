package dz.rgserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dz.rgserver.dao.ImageRepository;
import dz.rgserver.model.Image;

@RestController
@CrossOrigin("*")
public class ImageRestService {

	@Autowired
	private ImageRepository imageRepository; 
	
	@RequestMapping(value = "/images", method = RequestMethod.GET)
	public List<Image> listImage() {
		return imageRepository.findAll(); 
	}
	
	//@RequestMapping(value = "/images/find/{id}", method = RequestMethod.GET)
	//public List<Image> find(@PathVariable long id) {
		//return imageRepository.findByImageId(id); 
	//}
	
	
	
	
}
