package dz.rgserver.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dz.rgserver.model.RgAlimentaire;

@Repository
public interface RgAlimentaireRepository extends JpaRepository<RgAlimentaire, Long> {

}
