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
    
	@Query("select activite from Activite as activite where activite.type like :type")
    public Page<Activite> chercherActiviteParType(@Param("type")String type, Pageable pageable);
    
    @Query("select activite from Activite as activite where activite.domaine like :domaine")
    public Page<Activite> chercherActiviteParDomaine(@Param("domaine")String domaine, Pageable pageable);
    
    @Query("select activite from Activite as activite where activite.localisation like :localisation")
    public Page<Activite> chercherActiviteParLocalisation(@Param("localisation")String localisation, Pageable pageable);
    
   /* @Query("select activite from Activite as activite where activite.type like :event")
    public Page<Activite> getAllEvents(@Param("event")String event, Pageable pageable);*/
    
 
    
}
