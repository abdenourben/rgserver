package dz.rgserver.dao;

import dz.rgserver.model.Institution;
//import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InstitutionRepository extends JpaRepository<Institution, Long>{

	@Query(" select inst from Institution as inst where inst.nom like :x")
	public Page<Institution> chercherInstitutions (@Param("x")String mc , Pageable pageable );
	
}
