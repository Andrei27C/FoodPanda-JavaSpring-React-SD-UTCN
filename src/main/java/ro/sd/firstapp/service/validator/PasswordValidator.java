package ro.sd.firstapp.service.validator;

import org.springframework.stereotype.Component;

@Component
public class PasswordValidator {
    private static final String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[-_@$!%*?&])[A-Za-z\\d@_$!%*?&]{6,}$";

    public void validate(Object obj) throws Exception {
        String password = (String) obj;
        if (password == null || password.isEmpty() || !password.matches(PASSWORD_REGEX)) {
            throw new Exception("The password is not correct");
        }
    }
}
