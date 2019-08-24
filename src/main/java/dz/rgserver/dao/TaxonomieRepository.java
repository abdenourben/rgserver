package dz.rgserver.dao;

import dz.rgserver.model.RessourceGenetique;
import dz.rgserver.model.Taxonomie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TaxonomieRepository extends JpaRepository<Taxonomie, Long> {

	@Query(" select taxonomie from Taxonomie as taxonomie where taxonomie.classe like :x")
	public Page<Taxonomie> chercherTaxonomies (@Param("x")String mc , Pageable pageable );
	
	@Query(" select ressourceGenetiques from Taxonomie as ressources where Taxonomie.classe like :taxonomieClasse")
	public Page<RessourceGenetique> chercherTaxonomieClasse_RG (@Param("taxonomieClasse")String taxonomieClasse , Pageable pageable );

	@Query(" select ressourceGenetiques from Taxonomie as ressources where Taxonomie.ordre like :taxonomieOrdre")
	public Page<RessourceGenetique> chercherTaxonomieOrdre_RG (@Param("taxonomieOrdre")String taxonomieOrdre , Pageable pageable );

	@Query(" select ressourceGenetiques from Taxonomie as ressources where Taxonomie.famille like :taxonomieFamille")
	public Page<RessourceGenetique> chercherTaxonomieFamille_RG (@Param("taxonomieFamille")String taxonomieFamille , Pageable pageable );

	@Query(" select ressourceGenetiques from Taxonomie as ressources where Taxonomie.genre like :taxonomieGenre")
	public Page<RessourceGenetique> chercherTaxonomieGenre_RG (@Param("taxonomieGenre")String taxonomieGenre , Pageable pageable );

	@Query(" select ressourceGenetiques from Taxonomie as ressources where Taxonomie.espece like :taxonomieEspece")
	public Page<RessourceGenetique> chercherTaxonomieEspece_RG (@Param("taxonomieEspece")String taxonomieEspece , Pageable pageable );


}
