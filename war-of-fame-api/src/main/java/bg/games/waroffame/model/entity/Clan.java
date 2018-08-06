package bg.games.waroffame.model.entity;

import bg.games.waroffame.model.enumeration.RoleName;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

import java.util.Set;

import static bg.games.waroffame.util.AppConstants.ROLES;
import static bg.games.waroffame.util.AppConstants.ROLE_NAME_LENGH_VALUE;

@Entity
@Table(name = ROLES)
public class Clan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "clan")
    private Set<User> members;

    public Clan() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getMembers() {
        return members;
    }

    public void setMembers(Set<User> members) {
        this.members = members;
    }
}
