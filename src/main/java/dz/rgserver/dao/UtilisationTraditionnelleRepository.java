package dz.rgserver.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dz.rgserver.model.UtilisationTraditionnelle;

public interface UtilisationTraditionnelleRepository extends JpaRepository<UtilisationTraditionnelle, Long> {

@Query(" select use_trad from UtilisationTraditionnelle as use_trad where use_trad.description like :x")
public Page<UtilisationTraditionnelle> chercherUtilisationTraditionnelles (@Param("x")String mc , Pageable pageable );

}
