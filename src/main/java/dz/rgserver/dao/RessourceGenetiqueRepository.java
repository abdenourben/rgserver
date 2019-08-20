package dz.rgserver.dao;

import dz.rgserver.model.RessourceGenetique;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RessourceGenetiqueRepository extends JpaRepository<RessourceGenetique, Long>{

	@Query(" select rg from RessourceGenetique as rg where rg.designation_Fr like :x")
	public Page<RessourceGenetique> chercherRessourceGenetiques (@Param("x")String mc , Pageable pageable );
	

}
