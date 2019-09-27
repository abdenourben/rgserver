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

import dz.rgserver.dao.RoleRepository;
import dz.rgserver.model.Role;

@RestController
@CrossOrigin("*")
public class RoleRestService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	@RequestMapping(value="/roles", method = RequestMethod.GET)
	public List<Role> getAllRoles(){
	
		return roleRepository.findAll();
	}
	
	@RequestMapping(value="/roles/{id}", method = RequestMethod.GET)
	public Role getOneRole(@PathVariable long id ){
	
		return roleRepository.findById(id).get();
	}

	@RequestMapping(value="/roles", method = RequestMethod.POST)
	public Role saveRole(@RequestBody Role role ){
	
		return roleRepository.save(role);
	}
	
	@RequestMapping(value="/roles/{id}", method = RequestMethod.DELETE)
	public  boolean deleteRole(@PathVariable long id ){
		roleRepository.deleteById(id);
		return true;
	}
	
	@RequestMapping(value="/roles/{id}", method = RequestMethod.PUT)
	public Role updateRole(@PathVariable String name ,@RequestBody Role role ){
	
		role.setName(name);
		return roleRepository.save(role);
	}
	
	@RequestMapping(value="/chercherRoles", method = RequestMethod.GET)
	public Page<Role> chercherRoles(
			@RequestParam(name="mc",defaultValue = "") String mc, 
			@RequestParam(name="page",defaultValue = "0") int page, 
			@RequestParam(name="size",defaultValue = "5") int size){
	        
		return roleRepository.chercherRoles("%"+mc+"%", new PageRequest(page, size));
	}
	
	
}
