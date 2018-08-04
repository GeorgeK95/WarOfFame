package bg.games.waroffame.service.api;

import bg.games.waroffame.model.entity.Role;
import bg.games.waroffame.model.enumeration.RoleName;

import java.util.Optional;

public interface IRoleService {
    Optional<Role> findByName(RoleName roleUser);
}
