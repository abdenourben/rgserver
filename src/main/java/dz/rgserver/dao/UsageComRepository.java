package dz.rgserver.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import dz.rgserver.model.UsageCom;

@Repository
public interface UsageComRepository extends JpaRepository<UsageCom, Long> {

	public List<UsageCom> findByRgId(long id); 
}
