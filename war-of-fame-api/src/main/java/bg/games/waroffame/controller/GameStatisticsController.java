package bg.games.waroffame.controller;

import bg.games.waroffame.factory.StatisticsResponseModelFactory;
import bg.games.waroffame.model.response.StatisticsResponseModel;
import bg.games.waroffame.model.response.UserResponseModel;
import bg.games.waroffame.repository.UserRepository;
import bg.games.waroffame.util.DTOConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

import static bg.games.waroffame.util.AppConstants.GAME_URL;
import static bg.games.waroffame.util.AppConstants.IS_AUTHENTICATED;
import static bg.games.waroffame.util.AppConstants.STATISTICS_URL;

@RestController
@RequestMapping(GAME_URL)
@PreAuthorize(IS_AUTHENTICATED)
public class GameStatisticsController {

    private final UserRepository userRepository;

    public GameStatisticsController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(STATISTICS_URL)
    public ResponseEntity<?> game() {
        List<UserResponseModel> allUsers = DTOConverter.convert(this.userRepository.findAll(), UserResponseModel.class);
        List<UserResponseModel> sortedByTownsCount = DTOConverter.convert(this.userRepository.getAllByTownsCountDesc(),
                UserResponseModel.class);
        List<UserResponseModel> sortedByPopulation = DTOConverter.convert(this.userRepository.getAllByPopulationDesc(),
                UserResponseModel.class);

        StatisticsResponseModel responseModel =
                StatisticsResponseModelFactory.generateResponseModel(allUsers, sortedByTownsCount, sortedByPopulation);

        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }

}
