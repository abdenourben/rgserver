package dz.rgserver.dao;

import dz.rgserver.model.Image;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ImageRepository extends JpaRepository<Image, Long>{

	@Query(" select image from Image as image where image.titre like :x")
	public Page<Image> chercherImages (@Param("x")String mc , Pageable pageable );
	
}
