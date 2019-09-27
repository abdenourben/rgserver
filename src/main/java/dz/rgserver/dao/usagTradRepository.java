package dz.rgserver.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dz.rgserver.model.UsageTrad;


public interface usagTradRepository extends JpaRepository<UsageTrad, Long> {

	public List<UsageTrad> findByRgId(long id); 
	

}
