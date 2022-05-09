package ro.sd.firstapp.model.dto;

import lombok.*;
import ro.sd.firstapp.model.Restaurant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper=true)
public class AdminDTO extends UserDataDTO {
    private Restaurant restaurant;

    @Builder(builderMethodName = "AdminDTOBuilder")
    public AdminDTO(@NonNull String firstName, @NonNull String lastName, @NonNull String username, @NonNull String password, Restaurant restaurant) {
        super(firstName, lastName, username, password);
        this.restaurant = restaurant;
    }
}
