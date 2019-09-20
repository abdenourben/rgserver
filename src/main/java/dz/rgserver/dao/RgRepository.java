package dz.rgserver.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dz.rgserver.model.Rg;
import dz.rgserver.model.UsageCom;
import dz.rgserver.model.UsageTrad;

@Repository
public interface RgRepository extends JpaRepository<Rg, Long> {
	public List<Rg> findByInstitutionId(long id); 
	public List<Rg> findByTaxonomieId(long id); 



}
