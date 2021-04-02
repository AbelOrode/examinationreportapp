package ie.ait.ria.riaproject.repository;

import ie.ait.ria.riaproject.entity.Module;
import ie.ait.ria.riaproject.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
