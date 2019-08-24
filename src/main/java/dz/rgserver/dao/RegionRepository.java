package dz.rgserver.dao;

import dz.rgserver.model.Region;
import dz.rgserver.model.RessourceGenetique;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RegionRepository  extends JpaRepository<Region, Long> {

	@Query(" select region from Region as region where region.designation like :x")
	public Page<Region> chercherRegions (@Param("x")String mc , Pageable pageable );
	
	@Query(" select ressourceGenetiques from Region as ressources where region.wilaya like :wilaya")
	public Page<RessourceGenetique> chercherWilaya_RG (@Param("wilaya")String wilaya, Pageable pageable);
}
