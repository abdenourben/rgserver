package dz.rgserver.dao;

import dz.rgserver.model.Taxonomie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TaxonomieRepository extends JpaRepository<Taxonomie, Long> {

	@Query(" select taxonomie from Taxonomie as taxonomie where taxonomie.classe like :mc")
	public Page<Taxonomie> chercherTaxonomieClasse (@Param("mc")String mc , Pageable pageable );
	
	@Query(" select taxonomie from Taxonomie as taxonomie where taxonomie.ordre like :mc")
	public Page<Taxonomie> chercherTaxonomieOrdre (@Param("mc")String mc, Pageable pageable);
	
	@Query(" select taxonomie from Taxonomie as taxonomie where taxonomie.famille like :mc")
	public Page<Taxonomie> chercherTaxonomieFamille (@Param("mc")String mc, Pageable pageable);
	
	@Query(" select taxonomie from Taxonomie as taxonomie where taxonomie.genre like :mc")
	public Page<Taxonomie> chercherTaxonomieGenre (@Param("mc")String genre, Pageable pageable);
	
	@Query(" select taxonomie from Taxonomie as taxonomie where taxonomie.espece like :mc")
	public Page<Taxonomie> chercherTaxonomieEspece (@Param("mc")String mc, Pageable pageable);
	
	public Taxonomie findByRgId(long id);

	
}
