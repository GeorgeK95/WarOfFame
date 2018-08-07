package bg.games.waroffame.user.service.impl;

import bg.games.waroffame.user.model.entity.User;
import bg.games.waroffame.user.repository.UserRepository;
import bg.games.waroffame.app.service.IService;
import bg.games.waroffame.user.service.api.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService implements IUserService, IService<User> {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }
}
