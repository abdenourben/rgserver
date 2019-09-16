package dz.rgserver.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dz.rgserver.model.RgMarine;

@Repository
public interface RgMarineRepository extends JpaRepository<RgMarine, Long> {

}
