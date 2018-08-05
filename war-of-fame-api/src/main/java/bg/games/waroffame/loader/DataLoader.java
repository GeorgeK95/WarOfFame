package bg.games.waroffame.loader;

import bg.games.waroffame.model.entity.Role;
import bg.games.waroffame.model.entity.Town;
import bg.games.waroffame.model.entity.User;
import bg.games.waroffame.model.enumeration.RoleName;
import bg.games.waroffame.repository.RoleRepository;
import bg.games.waroffame.repository.TownRepository;
import bg.games.waroffame.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

import static bg.games.waroffame.util.AppConstants.MY_FIRST_TOWN;

@Component
public class DataLoader implements ApplicationRunner {

    private static final String ADMIN_EMAIL = "admin@abv.bg";
    private static final String ADMIN = "admin";
    private static final String ADMIN_PASS = "adminadmin";

    private static final String USER_EMAIL = "user@abv.bg";
    private static final String USER = "user";
    private static final String USER_PASS = "useruser";

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final TownRepository townRepository;

    @Autowired
    public DataLoader(UserRepository userRepository, RoleRepository roleRepository, TownRepository townRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.townRepository = townRepository;
    }

    @Override
    public void run(ApplicationArguments args) {
        this.seedUsers();
    }

    private void seedUsers() {
        Role roleUser = new Role(RoleName.ROLE_USER);
        Role roleAdmin = new Role(RoleName.ROLE_ADMIN);

        this.roleRepository.save(roleUser);
        this.roleRepository.save(roleAdmin);

        User admin = new User(ADMIN, ADMIN_EMAIL, ADMIN_PASS);
        admin.setRoles(Set.of(roleUser, roleAdmin));
        this.userRepository.save(admin);

        User user = new User(USER, USER_EMAIL, USER_PASS);
        user.setRoles(Set.of(roleUser));
        this.userRepository.save(user);

        Town initialTown = new Town(MY_FIRST_TOWN);
        initialTown.setOwner(user);
        this.townRepository.save(initialTown);
    }
}
