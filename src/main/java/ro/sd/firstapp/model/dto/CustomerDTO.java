package ro.sd.firstapp.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper=true)
public class CustomerDTO extends UserDataDTO {

    @NonNull
    private String address;

    @Builder(builderMethodName = "CustomerDTOBuilder")
    public CustomerDTO(@NonNull String firstName, @NonNull String lastName, @NonNull String username, @NonNull String password, String address) {
        super(firstName, lastName, username, password);
        this.address = address;
    }
}
