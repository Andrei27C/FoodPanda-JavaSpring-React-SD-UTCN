package ro.sd.firstapp.model.dto;

import lombok.*;
import ro.sd.firstapp.model.OrderStatus;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@ToString
public class OrderDTO {

    private Integer idOrder;

    @NonNull
    private CustomerDTO customer;

    @NonNull
    private RestaurantDTO restaurant;

    private OrderStatus status;

    @NonNull
    private List<FoodDTO> foods;

    @NonNull
    private Integer total;

}
