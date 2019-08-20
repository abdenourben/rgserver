package dz.rgserver.dao;

import dz.rgserver.model.Taxonomie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TaxonomieRepository extends JpaRepository<Taxonomie, Long> {

	@Query(" select taxonomie from Taxonomie as taxonomie where taxonomie.classe like :x")
	public Page<Taxonomie> chercherTaxonomies (@Param("x")String mc , Pageable pageable );
	
}
