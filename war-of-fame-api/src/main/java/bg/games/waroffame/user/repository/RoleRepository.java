package bg.games.waroffame.user.repository;

import bg.games.waroffame.user.model.entity.Role;
import bg.games.waroffame.user.model.enumeration.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}
