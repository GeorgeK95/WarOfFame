package bg.games.waroffame.factory;

import bg.games.waroffame.model.entity.Town;

public final class TownFactory {

    public static Town generateTown(String name) {
        return new Town(name);
    }

    private TownFactory() {
    }
}
