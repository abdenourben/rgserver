package dz.rgserver.dao;

import dz.rgserver.model.Region;
import dz.rgserver.model.Rg;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RgRepository extends JpaRepository<Rg, Long>{

	@Query(" select rg from Rg as rg where rg.nomCommunFr like :x")
	public Page<Rg> chercherRgsFr (@Param("x")String nomCommunFr , Pageable pageable );
	
	@Query(" select rg from Rg as rg where rg.nomCommunAr like :nomCommunAr")
	public Page<Rg> chercherRgsAr (@Param("nomCommunAr")String nomCommunAr , Pageable pageable );
	
	@Query(" select rg from Rg as rg where rg.nomScientifique like :nomScientifique")
	public Page<Rg> chercherRgsNomScientifique (@Param("nomScientifique")String nomScientifique , Pageable pageable );
	
	@Query(" select rg from Rg as rg where rg.environnement like :environnement")
	public Page<Rg> chercherRgsParEnvironnement (@Param("environnement")String environnement , Pageable pageable );
	
	@Query(" select rg from Rg as rg where rg.nomCommunFr like :nomCommunFr")
	public 	Page<Region> chercherRG_RegionsFR (@Param("nomCommunFr")String nomCommunFr, Pageable pageable);

	@Query(" select rg from Rg as rg where rg.nomCommunAr like :nomCommunAr")
	public Page<Region> chercherRG_RegionsAr (@Param("nomCommunAr")String nomCommunAr, Pageable pageable);

	public List<Rg> findByInstitutionId(long id); 
	public List<Rg> findByTaxonomieId(long id); 	
}
