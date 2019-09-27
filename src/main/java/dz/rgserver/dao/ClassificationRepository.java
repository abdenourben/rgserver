package dz.rgserver.dao;

import dz.rgserver.model.Classification;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClassificationRepository extends JpaRepository<Classification, Long>{

	@Query(" select classe from Classification as classe where classe.designation like :x")
	public Page<Classification> chercherClassifications (@Param("x")String mc , Pageable pageable );
	
/*	@Query("select * from rg where (select rg_id from classifications_rg as id2 where (select id from classifications as id1 where designation LIKE 'marine')= classification_id)=id;")
	public Page<Rg> chercherClassification_RG (@Param("designation_classification")String designation_classification , Pageable pageable );
	*/
}