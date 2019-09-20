package dz.rgserver.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import dz.rgserver.model.Taxonomie;

@Repository
public interface TaxonomieRepository extends JpaRepository<Taxonomie, Long> {

	public Taxonomie findByRgId(long id);
}
