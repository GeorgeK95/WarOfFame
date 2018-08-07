package bg.games.waroffame.user.model.entity;

import bg.games.waroffame.game.clan.model.entity.Clan;
import bg.games.waroffame.game.town.model.entity.Town;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

import static bg.games.waroffame.app.util.AppConstants.*;


@Entity
@Table(name = USERS, uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                USERNAME
        }),
        @UniqueConstraint(columnNames = {
                EMAIL
        })
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
//    @Min(USER_NAME_MIN_VALUE)
//    @Max(USER_NAME_MAX_VALUE)
    @Column(nullable = false, length = USER_NAME_MAX_VALUE)
    private String username;

    @NotBlank
//    @Max(EMAIL_MAX_VALUE)
    @Email
    @Column(unique = true, nullable = false, length = EMAIL_MAX_VALUE)
    private String email;

    @NotBlank
//    @Min(PASSWORD_MIN_VALUE)
    @Column(nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = USER_ROLES,
            joinColumns = @JoinColumn(name = USER_ID),
            inverseJoinColumns = @JoinColumn(name = ROLE_ID))
    private Set<Role> roles = new HashSet<>();

    @Column(nullable = false)
    private Boolean isBanned = false;

    @OneToMany(mappedBy = "owner")
    private Set<Town> towns;

    @ManyToOne
    private Clan clan;

    public User() {
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public int getTownsCount() {
        return this.towns.size();
    }

    public int getPopulation() {
        return this.towns.stream().mapToInt(Town::getPopulation).sum();
    }

    @PrePersist
    public void onPrePersist() {
        this.password = new BCryptPasswordEncoder().encode(this.password);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }

    public void addTown(Town town) {
        this.towns.add(town);
    }

    public Boolean getBanned() {
        return isBanned;
    }

    public void setBanned(Boolean banned) {
        isBanned = banned;
    }

    public Set<Town> getTowns() {
        return towns;
    }

    public void setTowns(Set<Town> towns) {
        this.towns = towns;
    }

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }
}