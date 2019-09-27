package dz.rgserver.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import dz.rgserver.model.Institution;

@Repository
public interface InstitutionRepository extends JpaRepository<Institution, Long> {
	
	public Institution findByRgId(long id); 

}
