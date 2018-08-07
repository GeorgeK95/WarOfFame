package bg.games.waroffame.game.statistics.controller;

import bg.games.waroffame.game.statistics.factory.StatisticsResponseModelFactory;
import bg.games.waroffame.game.town.model.response.StatisticsResponseModel;
import bg.games.waroffame.user.model.response.UserResponseModel;
import bg.games.waroffame.user.repository.UserRepository;
import bg.games.waroffame.app.util.DTOConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static bg.games.waroffame.app.util.AppConstants.GAME_URL;
import static bg.games.waroffame.app.util.AppConstants.IS_AUTHENTICATED;
import static bg.games.waroffame.app.util.AppConstants.STATISTICS_URL;

@RestController
@RequestMapping(GAME_URL)
@PreAuthorize(IS_AUTHENTICATED)
public class StatisticsController {

    private final UserRepository userRepository;

    public StatisticsController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(STATISTICS_URL)
    public ResponseEntity<?> game() {
        //todo: refactor service and controller architectures
        List<UserResponseModel> allUsers = DTOConverter.convert(this.userRepository.findAllOrderedById(), UserResponseModel.class);
        List<UserResponseModel> sortedByTownsCount = DTOConverter.convert(this.userRepository.getAllByTownsCountDesc(),
                UserResponseModel.class);
        List<UserResponseModel> sortedByPopulation = DTOConverter.convert(this.userRepository.getAllByPopulationDesc(),
                UserResponseModel.class);

        StatisticsResponseModel statisticsResponseModel =
                StatisticsResponseModelFactory.generateResponseModel(allUsers, sortedByTownsCount, sortedByPopulation);

            return new ResponseEntity<>(statisticsResponseModel, HttpStatus.OK);
    }

}
