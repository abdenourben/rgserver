package dz.rgserver.dao;

import dz.rgserver.model.Region;
import dz.rgserver.model.RessourceGenetique;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RessourceGenetiqueRepository extends JpaRepository<RessourceGenetique, Long>{

	@Query(" select rg from RessourceGenetique as rg where rg.designation_Fr like :x")
	public Page<RessourceGenetique> chercherRessourceGenetiques (@Param("x")String mc , Pageable pageable );
	
	@Query(" select rg from RessourceGenetique as rg where rg.nom_commun like :nom_commun")
	public Page<RessourceGenetique> chercherRessourceGenetiquesNomCommun (@Param("nom_commun")String nom_commun , Pageable pageable );

	@Query(" select rg from RessourceGenetique as rg where rg.nom_scientifique like :nom_scientifique")
	public Page<RessourceGenetique> chercherRessourceGenetiquesNomScientifique (@Param("nom_scientifique")String nom_scientifique , Pageable pageable );

	@Query(" select rg from RessourceGenetique as rg where rg.environnement like :environnement")
	public Page<RessourceGenetique> chercherRessourceGenetiquesParEnvironnement (@Param("environnement")String environnement , Pageable pageable );

	@Query(" select regions from RessourceGenetique as regions where RessourceGenetique.designation_Fr like :designation_Fr")
	public Page<Region> chercherRG_RegionsFR (@Param("designation_Fr")String designation_Fr , Pageable pageable);

	@Query(" select regions from RessourceGenetique as regions where RessourceGenetique.désignation_Ar like :désignation_Ar")
	public Page<Region> chercherRG_RegionsAr (@Param("désignation_Ar")String désignation_Ar , Pageable pageable);
}
