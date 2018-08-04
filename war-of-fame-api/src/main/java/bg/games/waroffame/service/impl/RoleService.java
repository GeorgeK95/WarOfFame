package bg.games.waroffame.service.impl;

import bg.games.waroffame.model.entity.Role;
import bg.games.waroffame.model.enumeration.RoleName;
import bg.games.waroffame.repository.RoleRepository;
import bg.games.waroffame.service.api.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class RoleService implements IRoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Optional<Role> findByName(RoleName roleUser) {
        return this.roleRepository.findByName(RoleName.ROLE_USER);
    }
}
