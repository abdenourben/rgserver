package dz.rgserver.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import dz.rgserver.model.UsageTrad;

@Repository
public interface UsageTradRepository extends JpaRepository<UsageTrad, Long> {
	
	public List<UsageTrad> findByRgId(long id); 

}
