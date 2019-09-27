package dz.rgserver.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dz.rgserver.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{


	@Query(" select role from Role as role where role.name like :x")
	public Page<Role> chercherRoles (@Param("x")String mc , Pageable pageable );
	
}
