package ro.sd.firstapp.model.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class LoginDTO {

    @NotNull(message = "Username should not be null.")
    @Size(min = 1, message = "Username should not be null.")
    private String username;

    @NotNull(message = "Password is required.")
    @Size(min = 8, message = "Password should be at least 8 characters.")
    private String password;
}