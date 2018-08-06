package bg.games.waroffame.model.response;

public class UserResponseModel {

    private Long id;
    private String username;
    private int townsCount;
    private int population;
    private ClanResponseModel clan;

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

    public int getTownsCount() {
        return townsCount;
    }

    public void setTownsCount(int townsCount) {
        this.townsCount = townsCount;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public ClanResponseModel getClan() {
        return clan;
    }

    public void setClan(ClanResponseModel clan) {
        this.clan = clan;
    }
}
