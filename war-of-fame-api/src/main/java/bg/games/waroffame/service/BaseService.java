package bg.games.waroffame.service;

import bg.games.waroffame.model.request.SignUpRequestModel;
import bg.games.waroffame.model.response.HttpErrorResponseModel;
import bg.games.waroffame.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

import static bg.games.waroffame.util.AppConstants.*;

public abstract class BaseService<T> {

    protected final UserRepository userRepository;

    protected BaseService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    protected ResponseEntity<?> validateSignUpData(SignUpRequestModel signUpRequestModel) {
        if (userRepository.existsByUsername(signUpRequestModel.getUsername()))
            return new ResponseEntity(new HttpErrorResponseModel(HttpStatus.CONFLICT.value(), USERNAME_IS_ALREADY_TAKEN_MESSAGE),
                    HttpStatus.CONFLICT);

        if (userRepository.existsByEmail(signUpRequestModel.getEmail()))
            return new ResponseEntity(new HttpErrorResponseModel(HttpStatus.CONFLICT.value(), EMAIL_ADDRESS_ALREADY_IN_USE_MESSAGE),
                    HttpStatus.CONFLICT);

        if (!signUpRequestModel.getPassword().equals(signUpRequestModel.getConfirm()))
            return new ResponseEntity(new HttpErrorResponseModel(HttpStatus.BAD_REQUEST.value(), PASSWORDS_MISMATCH_MESSAGE),
                    HttpStatus.BAD_REQUEST);

        return null;
    }

    protected Map<String, String> processErrors(Errors errors) {
        Map<String, String> errorsByField = new HashMap<>();
        for (FieldError current : errors.getFieldErrors())
            errorsByField.put(current.getField(), current.getDefaultMessage());
        return errorsByField;
    }
}
