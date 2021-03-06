package bg.games.waroffame.auth.model.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import static bg.games.waroffame.app.util.AppConstants.*;

public class SignInRequestModel {

    @NotBlank
    @Size(min = USER_NAME_MIN_VALUE, max = USER_NAME_MAX_VALUE)
    private String username;

    @NotBlank
    @Size(min = PASSWORD_MIN_VALUE, max = PASSWORD_MAX_VALUE)
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
