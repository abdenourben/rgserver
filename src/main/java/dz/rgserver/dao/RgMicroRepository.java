package dz.rgserver.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dz.rgserver.model.RgMicro;

@Repository
public interface RgMicroRepository extends JpaRepository<RgMicro, Long> {

}
