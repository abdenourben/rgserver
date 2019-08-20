package dz.rgserver.dao;

import dz.rgserver.model.DemandePermis;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DemandePermisRepository extends JpaRepository<DemandePermis, Long>{

	@Query(" select dmd from DemandePermis as dmd where dmd.etat like :x")
	public Page<DemandePermis> chercherDemandePermis (@Param("x")String mc , Pageable pageable );
	
}
