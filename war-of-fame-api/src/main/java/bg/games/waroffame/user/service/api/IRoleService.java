package bg.games.waroffame.user.service.api;

import bg.games.waroffame.user.model.entity.Role;
import bg.games.waroffame.user.model.enumeration.RoleName;

import java.util.Optional;

public interface IRoleService {
    Optional<Role> findByName(RoleName roleUser);
}
