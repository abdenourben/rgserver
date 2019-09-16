package dz.rgserver.controller;

import java.util.ArrayList;
import java.util.List;

import dz.rgserver.dao.RgAlimentaireRepository;
import dz.rgserver.dao.RgAnimaleRepository;
import dz.rgserver.dao.RgForetRepository;
import dz.rgserver.dao.RgMarineRepository;
import dz.rgserver.dao.RgMicroRepository;
import dz.rgserver.dao.RgRepository;
import dz.rgserver.model.Activite;
import dz.rgserver.model.Region;
import dz.rgserver.model.Rg;
import dz.rgserver.model.RgAlimentaire;
import dz.rgserver.model.RgAnimale;
import dz.rgserver.model.RgForet;
import dz.rgserver.model.RgMarine;
import dz.rgserver.model.RgMicro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin("*")
public class RgRestService {
	
	@Autowired
	private RgRepository rgRepository;
	
	@Autowired
	private RgMarineRepository rgMarineRepository;
	
	@Autowired
	private RgAlimentaireRepository rgAlimentaireRepository; 
	
	@Autowired
	private RgAnimaleRepository rgAnimaleRepository; 
	
	@Autowired
	private RgMicroRepository rgMicroRepository; 
	
	@Autowired
	private RgForetRepository rgForetRepository; 
	
    @PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value="/rg", method = RequestMethod.GET)
	public List<Rg> listRg(){
		return rgRepository.findAll();
	}
    
    @PreAuthorize("hasRole('ADMIN')")
  	@RequestMapping(value="/rg/marine", method = RequestMethod.GET)
  	public List<RgMarine> listRgMarine(){
  		return rgMarineRepository.findAll();
  	}
    
    @PreAuthorize("hasRole('ADMIN')")
  	@RequestMapping(value="/rg/alimentaire", method = RequestMethod.GET)
  	public List<RgAlimentaire> listRgAlimentaire(){
  		return rgAlimentaireRepository.findAll(); 
    }
    
    @PreAuthorize("hasRole('ADMIN')")
  	@RequestMapping(value="/rg/animale", method = RequestMethod.GET)
  	public List<RgAnimale> listRgAnimale(){
  		return rgAnimaleRepository.findAll(); 
    }
    
    @PreAuthorize("hasRole('ADMIN')")
   	@RequestMapping(value="/rg/micro", method = RequestMethod.GET)
   	public List<RgMicro> listRgMicro(){
   		return rgMicroRepository.findAll(); 
    }
    
    @PreAuthorize("hasRole('ADMIN')")
   	@RequestMapping(value="/rg/foret", method = RequestMethod.GET)
   	public List<RgForet> listRgForet(){
   		return rgForetRepository.findAll(); 
    }
    
    
}