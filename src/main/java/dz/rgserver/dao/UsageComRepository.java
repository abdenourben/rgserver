package dz.rgserver.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dz.rgserver.model.UsageCom;


public interface UsageComRepository  extends JpaRepository<UsageCom, Long>{

	@Query(" select UsageCom from UsageCom as UsageCom where UsageCom.secteur like :x")
	public Page<UsageCom> chercherUtilisationCommerciales (@Param("x")String mc , Pageable pageable );

	public List<UsageCom> findByRgId(long id); 

}
