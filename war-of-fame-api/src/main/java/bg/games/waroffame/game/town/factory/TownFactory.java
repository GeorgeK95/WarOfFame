package bg.games.waroffame.game.town.factory;

import bg.games.waroffame.game.town.model.entity.Town;

public final class TownFactory {

    public static Town generateTown(String name) {
        return new Town(name);
    }

    private TownFactory() {
    }
}
