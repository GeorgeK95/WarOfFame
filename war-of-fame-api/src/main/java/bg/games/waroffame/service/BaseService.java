package bg.games.waroffame.service;

import bg.games.waroffame.model.request.SignUpRequestModel;
import bg.games.waroffame.model.response.ApiResponseModel;
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

    protected ResponseEntity<?> vaidateSignUpData(SignUpRequestModel signUpRequestModel) {
        if (userRepository.existsByUsername(signUpRequestModel.getUsername()))
            return new ResponseEntity(new ApiResponseModel(false, USERNAME_IS_ALREADY_TAKEN_MESSAGE),
                    HttpStatus.BAD_REQUEST);

        if (userRepository.existsByEmail(signUpRequestModel.getEmail()))
            return new ResponseEntity(new ApiResponseModel(false, EMAIL_ADDRESS_ALREADY_IN_USE_MESSAGE),
                    HttpStatus.BAD_REQUEST);

        if (!signUpRequestModel.getPassword().equals(signUpRequestModel.getConfirm()))
            return new ResponseEntity(new ApiResponseModel(false, PASSWORDS_MISMATCH_MESSAGE),
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