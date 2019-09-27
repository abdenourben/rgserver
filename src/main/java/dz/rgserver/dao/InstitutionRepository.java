package dz.rgserver.dao;

import dz.rgserver.model.Institution;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InstitutionRepository extends JpaRepository<Institution, Long>{

	@Query(" select institution from Institution as institution where institution.nom like :x")
	public Page<Institution> chercherInstitutionsNom (@Param("x")String mc , Pageable pageable );
	
	@Query("select institution from Institution as institution where institution.raison like :raisonSociale")
    public Page<Institution> chercherInstitutionRaison(@Param("raisonSociale")String mc, Pageable pageable);
	

	@Query("select institution from Institution as institution where institution.statut like :statutJuridique")
    public Page<Institution> chercherInstitutionstatut(@Param("statutJuridique")String mc, Pageable pageable);
	
	@Query("select institution from Institution as institution where institution.categorie like :categorie")
    public Page<Institution> chercherInstitutionCategorie(@Param("categorie")String mc, Pageable pageable);
	
	@Query("select institution from Institution as institution where institution.secteur like :secteurActivite")
    public Page<Institution> chercherInstitutionSecteur(@Param("secteurActivite")String mc, Pageable pageable);

	@Query("select institution from Institution as institution where institution.typeApa like :typeImplicationApa")
    public Page<Institution> chercherInstitutionTypeImplication(@Param("typeImplicationApa")String mc, Pageable pageable);
	
	@Query("select institution from Institution as institution where institution.type like :type")
    public Page<Institution> chercherInstitutionType(@Param("type") String mc, Pageable pageable);
   
	public Institution findByRgId(long id); 

}
