package dz.rgserver.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dz.rgserver.model.RgAnimale;

@Repository
public interface RgAnimaleRepository extends JpaRepository<RgAnimale, Long> {

}
