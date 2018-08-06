package bg.games.waroffame.repository;

import bg.games.waroffame.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByIdIn(List<Long> userIds);

    @Query("select u from User u order by size(u.towns) desc")
    List<User> getAllByTownsCountDesc();

    @Query("select u from User u join u.towns t group by u order by sum(t.population) desc")
    List<User> getAllByPopulationDesc();

    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
