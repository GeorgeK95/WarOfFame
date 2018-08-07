package bg.games.waroffame.app.loader;

import bg.games.waroffame.user.model.entity.Role;
import bg.games.waroffame.game.town.model.entity.Town;
import bg.games.waroffame.user.model.entity.User;
import bg.games.waroffame.user.model.enumeration.RoleName;
import bg.games.waroffame.user.repository.RoleRepository;
import bg.games.waroffame.game.town.repository.TownRepository;
import bg.games.waroffame.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

import static bg.games.waroffame.app.util.AppConstants.MY_FIRST_TOWN;

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

        /*User user2 = new User("user2", "user2@abv.bg", "user2");
        user2.setRoles(Set.of(roleUser));
        this.userRepository.save(user2);

        User user3 = new User("user3", "user3@abv.bg", "user3");
        user3.setRoles(Set.of(roleUser));
        this.userRepository.save(user3);

        User user4 = new User("user4", "user4@abv.bg", "user4");
        user4.setRoles(Set.of(roleUser));
        this.userRepository.save(user4);

        User user5 = new User("user5", "user5@abv.bg", "user5");
        user5.setRoles(Set.of(roleUser));
        this.userRepository.save(user5);

        User user6 = new User("user6", "user6@abv.bg", "user6");
        user6.setRoles(Set.of(roleUser));
        this.userRepository.save(user6);

        User user7 = new User("user7", "user7@abv.bg", "user7");
        user7.setRoles(Set.of(roleUser));
        this.userRepository.save(user7);

        User user8 = new User("user8", "user8@abv.bg", "user8");
        user8.setRoles(Set.of(roleUser));
        this.userRepository.save(user8);

        User user9 = new User("user9", "user9@abv.bg", "user9");
        user9.setRoles(Set.of(roleUser));
        this.userRepository.save(user9);

        User user10 = new User("user10", "user10@abv.bg", "user10");
        user10.setRoles(Set.of(roleUser));
        this.userRepository.save(user10);*/
    }
}
