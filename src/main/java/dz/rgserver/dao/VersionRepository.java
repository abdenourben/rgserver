package dz.rgserver.dao;

import org.springframework.data.domain.Pageable;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;


import dz.rgserver.model.Version;
@Repository 

public interface VersionRepository extends JpaRepository<Version, Long>{
	
	
	
	@Query(" select v from Version as v where v.idRessource = :x order by num_version desc")
	public Page<Version> getVersionByIdRessouce (@Param("x")Long nbr , Pageable pageable );
	

	
}
