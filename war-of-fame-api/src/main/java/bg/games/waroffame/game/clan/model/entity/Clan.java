package bg.games.waroffame.game.clan.model.entity;

import bg.games.waroffame.user.model.entity.User;

import javax.persistence.*;

import java.util.Set;

import static bg.games.waroffame.app.util.AppConstants.*;

@Entity
@Table(name = CLANS)
public class Clan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = CLAN_NAME_MAX_VALUE, unique = true)
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
