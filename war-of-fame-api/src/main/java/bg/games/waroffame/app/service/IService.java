package bg.games.waroffame.app.service;

import java.util.List;

public interface IService<T> {
    List<T> findAll();
}
