package dz.rgserver.dao;

import dz.rgserver.model.Image;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ImageRepository extends JpaRepository<Image, Long>{

	@Query(" select image from Image as image where image.titre like :x")
	public Page<Image> chercherImagesTitre (@Param("x")String titre , Pageable pageable );
	
	@Query(" select image from Image as image where image.type like :x")
	public Page<Image> chercherImagesType (@Param("x")String type , Pageable pageable );
	
	//public List<Image> findByImageId(long id); 
}
