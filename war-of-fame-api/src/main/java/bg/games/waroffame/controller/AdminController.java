package bg.games.waroffame.controller;

import bg.games.waroffame.service.api.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static bg.games.waroffame.util.AppConstants.*;

@RestController
@RequestMapping(ADMIN_URL)
@PreAuthorize(IS_ADMIN)
public class AdminController {

    private final IUserService userService;

    public AdminController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping(USERS_URL)
    public ResponseEntity<?> getAllUsers() {
        return new ResponseEntity<>(this.userService.findAll(), HttpStatus.OK);
    }
}
