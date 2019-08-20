package dz.rgserver.dao;

import dz.rgserver.model.Activite;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ActiviteRepository extends JpaRepository<Activite, Long> {

	@Query(" select activite from Activite as activite where activite.titre like :x")
	public Page<Activite> chercherActivites (@Param("x")String mc , Pageable pageable );
}
