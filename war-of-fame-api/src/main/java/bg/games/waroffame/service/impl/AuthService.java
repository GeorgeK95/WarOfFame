package bg.games.waroffame.service.impl;

import bg.games.waroffame.model.entity.User;
import bg.games.waroffame.model.enumeration.RoleName;
import bg.games.waroffame.model.request.SignInRequestModel;
import bg.games.waroffame.model.request.SignUpRequestModel;
import bg.games.waroffame.model.response.JwtAuthenticationResponseModel;
import bg.games.waroffame.repository.UserRepository;
import bg.games.waroffame.security.jwt.JwtTokenProvider;
import bg.games.waroffame.service.BaseService;
import bg.games.waroffame.service.api.IAuthService;
import bg.games.waroffame.service.api.IRoleService;
import bg.games.waroffame.util.DTOConverter;
import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;

import static bg.games.waroffame.util.AppConstants.*;
import static bg.games.waroffame.util.AppConstants.USER_REGISTERED_SUCCESSFULLY_MESSAGE;

@Service
@Transactional
public class AuthService extends BaseService implements IAuthService {

    private final JwtTokenProvider tokenProvider;

    private final AuthenticationManager authenticationManager;

    private final IRoleService roleService;

    private final PasswordEncoder passwordEncoder;

    public AuthService(JwtTokenProvider tokenProvider, AuthenticationManager authenticationManager,
                       UserRepository userRepository, IRoleService roleService,
                       PasswordEncoder passwordEncoder) {
        super(userRepository);
        this.tokenProvider = tokenProvider;
        this.authenticationManager = authenticationManager;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public ResponseEntity<?> signInUser(SignInRequestModel signInRequestModel, Errors errors) {
        if (errors.hasErrors()) return new ResponseEntity(super.processErrors(errors), HttpStatus.BAD_REQUEST);

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        signInRequestModel.getUsername(),
                        signInRequestModel.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponseModel(jwt));
    }

    @Override
    public ResponseEntity<?> signUpUser(SignUpRequestModel signUpRequestModel, Errors errors) {
        if (errors.hasErrors()) return new ResponseEntity(super.processErrors(errors), HttpStatus.BAD_REQUEST);

        ResponseEntity<?> validated = super.vaidateSignUpData(signUpRequestModel);

        if (validated != null) return validated;

        User user = DTOConverter.convert(signUpRequestModel, User.class);
        user.addRole(this.roleService.findByName(RoleName.ROLE_USER).get());

        super.userRepository.save(user);

        return new ResponseEntity<>(new Gson().toJson(USER_REGISTERED_SUCCESSFULLY_MESSAGE), HttpStatus.CREATED);
    }

}
