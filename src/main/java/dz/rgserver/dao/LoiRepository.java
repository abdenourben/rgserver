package dz.rgserver.dao;

import dz.rgserver.model.Loi;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;

public interface LoiRepository extends JpaRepository<Loi, Long>{

	@Query(" select loi from Loi as loi where loi.designation like :x")
	public Page<Loi> chercherLois (@Param("x")String mc , Pageable pageable );
	
	@Query("select loi from Loi as loi where loi.anneeLoi like :anneeLoi")
    public Page<Loi> chercherLoiParAnnee(@Param("anneeLoi") @DateTimeFormat(pattern = "dd.MM.yyyy")Date anneeLoi, Pageable pageable);

}
