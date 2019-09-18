package dz.rgserver.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import dz.rgserver.model.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {

	//public List<Image> findByImageId(long id); 
}
