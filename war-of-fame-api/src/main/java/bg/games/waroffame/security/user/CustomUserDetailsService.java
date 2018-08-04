package bg.games.waroffame.security.user;

import bg.games.waroffame.exception.ResourceNotFoundException;
import bg.games.waroffame.model.entity.User;
import bg.games.waroffame.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static bg.games.waroffame.util.AppConstants.*;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);

        this.validateUser(user, username);

        return UserPrincipal.create(user.get());
    }

    @Transactional
    public UserDetails loadUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(USER_UPPERCASE, ID, id));

        return UserPrincipal.create(user);
    }

    private void validateUser(Optional<User> user, String username) {
        if (!user.isPresent())
            throw new UsernameNotFoundException(USER_NOT_FOUND_WITH_USERNAME_OR_EMAIL_MESSAGE + username);

        if (user.get().getBanned())
            throw new UsernameNotFoundException(BANNED_USER_MESSAGE);
    }
}