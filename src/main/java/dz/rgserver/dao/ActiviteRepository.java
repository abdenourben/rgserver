package dz.rgserver.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.format.annotation.DateTimeFormat;

import dz.rgserver.model.Activite;

public interface ActiviteRepository extends JpaRepository<Activite, Long> {

@Query(" select activite from Activite as activite where activite.titre like :x")
public Page<Activite> chercherActivites (@Param("x")String mc , Pageable pageable );



@Query(" select activite from Activite as activite where activite.type like :type")
public Page<Activite> chercherActiviteParType (@Param("type")String type , Pageable pageable );
    
@Query("select activite from Activite as activite where activite.domaine like :domaine")
public Page<Activite> chercherActiviteParDomaine(@Param("domaine")String domaine , Pageable pageable );
    
@Query("select activite from Activite as activite where activite.date_debut like :date")
public Page<Activite> chercherActiviteParDateDebut(@Param("date") @DateTimeFormat(pattern = "dd.MM.yyyy") String date , Pageable pageable );
   
@Query("select activite from Activite as activite where activite.localisation like :localisation")
public Page<Activite> chercherActiviteParLocalisation(@Param("localisation")String localisation, Pageable pageable );
}
