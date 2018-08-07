package bg.games.waroffame.auth.controller;

import bg.games.waroffame.auth.model.request.SignInRequestModel;
import bg.games.waroffame.auth.model.request.SignUpRequestModel;
import bg.games.waroffame.auth.service.api.IAuthService;
import bg.games.waroffame.user.service.api.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static bg.games.waroffame.app.util.AppConstants.*;

@RestController
@RequestMapping(AUTH_URL)
public class AuthController {

    private final IAuthService authService;

    private final IUserService userService;

    @Autowired
    public AuthController(IAuthService authService, IUserService userService) {
        this.authService = authService;
        this.userService = userService;
    }

    @PostMapping(SIGNUP_URL)
    public ResponseEntity<?> signUpUser(@Valid @RequestBody SignUpRequestModel signUpRequestModel, Errors errors) {
        return this.authService.signUpUser(signUpRequestModel, errors);
    }

    @PostMapping(SIGNIN_URL)
    public ResponseEntity<?> signInUser(@Valid @RequestBody SignInRequestModel signInRequestModel, Errors errors) {
        return this.authService.signInUser(signInRequestModel, errors);
    }
}
