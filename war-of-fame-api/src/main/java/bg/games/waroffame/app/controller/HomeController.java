package bg.games.waroffame.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static bg.games.waroffame.app.util.AppConstants.HOME_URL;

@RestController
public class HomeController {

    @GetMapping(HOME_URL)
    public ResponseEntity<?> home() {
        String welcomeMsg = "War Of Fame home page unauthorized.";
        return new ResponseEntity<>(welcomeMsg, HttpStatus.OK);
    }
}
