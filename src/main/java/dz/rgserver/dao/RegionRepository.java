package dz.rgserver.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import dz.rgserver.model.Region;

public interface RegionRepository extends JpaRepository<Region, Long> {
	
}
