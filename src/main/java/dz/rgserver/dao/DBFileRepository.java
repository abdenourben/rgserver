package dz.rgserver.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dz.rgserver.model.DBFile;

@Repository
public interface DBFileRepository extends JpaRepository<DBFile,Long>{

}
