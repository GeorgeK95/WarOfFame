package bg.games.waroffame.service.api;

import bg.games.waroffame.model.request.SignInRequestModel;
import bg.games.waroffame.model.request.SignUpRequestModel;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;

public interface IAuthService {
    ResponseEntity<?> signUpUser(SignUpRequestModel signUpRequestModel, Errors errors);

    ResponseEntity<?> signInUser(SignInRequestModel signInRequestModel, Errors errors);
}
