package dz.rgserver.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dz.rgserver.model.RgForet;

@Repository
public interface RgForetRepository extends JpaRepository<RgForet, Long> {

}
