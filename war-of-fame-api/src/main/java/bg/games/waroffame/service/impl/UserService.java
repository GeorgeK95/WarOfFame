package bg.games.waroffame.service.impl;

import bg.games.waroffame.model.entity.User;
import bg.games.waroffame.repository.UserRepository;
import bg.games.waroffame.service.api.IService;
import bg.games.waroffame.service.api.IUserService;
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
