package bg.games.waroffame.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static bg.games.waroffame.util.AppConstants.GAME_URL;
import static bg.games.waroffame.util.AppConstants.IS_AUTHENTICATED;

@RestController
@RequestMapping(GAME_URL)
@PreAuthorize(IS_AUTHENTICATED)
public class GameController {

    @GetMapping
    public ResponseEntity<?> game() {
        String gameMsg = "Game page, authorization required.";
        return new ResponseEntity<>(gameMsg, HttpStatus.OK);
    }
}

