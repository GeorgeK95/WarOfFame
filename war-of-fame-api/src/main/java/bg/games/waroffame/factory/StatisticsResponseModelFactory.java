package bg.games.waroffame.factory;

import bg.games.waroffame.model.response.StatisticsResponseModel;
import bg.games.waroffame.model.response.UserResponseModel;

import java.util.List;

public final class StatisticsResponseModelFactory {

    public static StatisticsResponseModel generateResponseModel(List<UserResponseModel> allUsers, List<UserResponseModel> sortedByTownsCount, List<UserResponseModel> sortedByPopulation) {
        return new StatisticsResponseModel(allUsers, sortedByTownsCount, sortedByPopulation);
    }

    private StatisticsResponseModelFactory() {
    }
}
