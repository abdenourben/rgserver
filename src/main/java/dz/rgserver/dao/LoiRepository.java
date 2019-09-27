package dz.rgserver.dao;




import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;

import dz.rgserver.model.Loi;

public interface LoiRepository extends JpaRepository<Loi, Long>{

	@Query(" select loi from Loi as loi where loi.designation like :x")
	public Page<Loi> chercherLois (@Param("x")String mc , Pageable pageable );
	
	@Query(" select loi from Loi as loi where loi.annee_loi like :mc")
    public List<Loi> chercherLoiParAnnee(Date mc);
	

}
