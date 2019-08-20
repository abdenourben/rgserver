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
	
}