package dz.rgserver.dao;

import dz.rgserver.model.Institution;
//import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import dz.rgserver.model.RessourceGenetique;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;

public interface InstitutionRepository extends JpaRepository<Institution, Long>{

	@Query(" select inst from Institution as inst where inst.nom like :x")
	public Page<Institution> chercherInstitutions (@Param("x")String mc , Pageable pageable );
	
	@Query("select institution from Institution as institution where institution.raisonSociale like :raisonSociale")
    public Page<Institution> chercherInstitutionParRaison(@Param("raisonSociale")String raisonSociale, Pageable pageable);


@Query("select institution from Institution as institution where institution.natureEtabelissement like :natureEtabelissement")
    public Page<Institution> chercherInstitutionParNature(@Param("natureEtabelissement")String natureEtabelissement, Pageable pageable);

@Query("select institution from Institution as institution where institution.secteurActivite like :secteurActivite")
    public Page<Institution> chercherInstitutionParSecteur(@Param("secteurActivite")String secteurActivite, Pageable pageable);

@Query("select institution from Institution as institution where institution.anneeImplicationApa like :anneeImplicationApa")
    public Page<Institution> chercherInstitutionParAnnéeAPA(@Param("anneeImplicationApa") @DateTimeFormat(pattern = "dd.MM.yyyy") Date anneeImplicationApa, Pageable pageable);
   
@Query(" select ressourceGenetiques from Institution as ressources where Institution.nom like :nom")
public Page<RessourceGenetique> chercherInstitution_RG (@Param("nom")String nom, Pageable pageable);
}
