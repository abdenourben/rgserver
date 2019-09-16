package dz.rgserver.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dz.rgserver.model.Rg;

@Repository
public interface RgRepository extends JpaRepository<Rg, Long> {

}
