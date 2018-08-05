package bg.games.waroffame.model.entity;

import bg.games.waroffame.model.enumeration.RoleName;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

import static bg.games.waroffame.util.AppConstants.TOWNS;
import static bg.games.waroffame.util.AppConstants.TOWN_NAME_LENGH_VALUE;

@Entity
@Table(name = TOWNS)
public class Town {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = TOWN_NAME_LENGH_VALUE, nullable = false)
    private String name;

    @Column(nullable = false)
    private int population = 0;

    @ManyToOne
    private User owner;

    public Town() {
    }

    public Town(String name) {
        this.name = name;
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

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
