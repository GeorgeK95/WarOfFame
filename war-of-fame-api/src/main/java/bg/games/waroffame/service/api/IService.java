package bg.games.waroffame.service.api;

import java.util.List;

public interface IService<T> {
    List<T> findAll();
}
