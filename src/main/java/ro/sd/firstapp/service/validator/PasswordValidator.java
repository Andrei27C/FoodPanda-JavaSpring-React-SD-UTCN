package ro.sd.firstapp.service.validator;

import org.springframework.stereotype.Component;

/**
 * Validator of a password.
 */
@Component
public class PasswordValidator {
    private static final String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[-_@$!%*?&])[A-Za-z\\d@_$!%*?&]{6,}$";

    /**
     * Validate the password.
     * @param password - which is validated
     */
    public void validate(String password) throws Exception {
        if (password == null || password.isEmpty() || !password.matches(PASSWORD_REGEX)) {
            throw new Exception("The password is not correct");
        }
    }
}
