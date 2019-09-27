package dz.rgserver.dao;

import dz.rgserver.model.DemandePermis;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

public interface DemandePermisRepository extends JpaRepository<DemandePermis, Long>{

	@Query(" select dmd from DemandePermis as dmd where dmd.etat like :x")
	public Page<DemandePermis> chercherDemandePermis (@Param("x")String mc , Pageable pageable );
	
	@Query("update DemandePermis p set p.etat = :etat where p.id = :id")
	@Modifying
	public DemandePermis nePasAutoriserDemandePermis(@PathVariable long id );
	
	@Query("update DemandePermis demande set demande.etat = :etat where demande.id = :id")
	@Modifying
	public DemandePermis autoriserDemandePermis(@PathVariable("id") long id );
	
	@Query("update DemandePermis d set d.etat = :etat where d.id = :id")
	@Modifying
	public void mettreEnAttenteDemandePermis(@PathVariable("id") long id );
}
