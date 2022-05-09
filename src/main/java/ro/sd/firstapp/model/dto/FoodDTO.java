package ro.sd.firstapp.model.dto;

import lombok.*;
import ro.sd.firstapp.model.FoodCategory;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class FoodDTO {
    @NonNull
    private String name;
    @NonNull
    private Integer price;
    @NonNull
    private String description;
    @NonNull
    private FoodCategory category;
    @NonNull
    private RestaurantDTO restaurantDTO;
}
