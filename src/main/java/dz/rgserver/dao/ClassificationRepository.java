package dz.rgserver.dao;

import dz.rgserver.model.Classification;
import dz.rgserver.model.RessourceGenetique;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClassificationRepository extends JpaRepository<Classification, Long>{

	@Query(" select classe from Classification as classe where classe.designation like :x")
	public Page<Classification> chercherClassifications (@Param("x")String mc , Pageable pageable );
	
	@Query(" select ressourceGenetiques from Classification as ressources where Classification.designation like :designation")
	public Page<RessourceGenetique> chercherClassification_RG(@Param("designation")String designation_classification, Pageable pageable);
}
