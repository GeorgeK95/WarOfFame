package bg.games.waroffame.model.response;

import java.util.List;

public class StatisticsResponseModel {

    private List<UserResponseModel> allUsers;
    private List<UserResponseModel> sortedByTownsCount;
    private List<UserResponseModel> sortedByPopulation;

    public StatisticsResponseModel() {
    }

    public StatisticsResponseModel(List<UserResponseModel> allUsers, List<UserResponseModel> sortedByTownsCount, List<UserResponseModel> sortedByPopulation) {
        this.allUsers = allUsers;
        this.sortedByTownsCount = sortedByTownsCount;
        this.sortedByPopulation = sortedByPopulation;
    }

    public List<UserResponseModel> getAllUsers() {
        return allUsers;
    }

    public void setAllUsers(List<UserResponseModel> allUsers) {
        this.allUsers = allUsers;
    }

    public List<UserResponseModel> getSortedByTownsCount() {
        return sortedByTownsCount;
    }

    public void setSortedByTownsCount(List<UserResponseModel> sortedByTownsCount) {
        this.sortedByTownsCount = sortedByTownsCount;
    }

    public List<UserResponseModel> getSortedByPopulation() {
        return sortedByPopulation;
    }

    public void setSortedByPopulation(List<UserResponseModel> sortedByPopulation) {
        this.sortedByPopulation = sortedByPopulation;
    }
}
