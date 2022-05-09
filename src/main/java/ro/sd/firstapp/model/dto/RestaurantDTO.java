package ro.sd.firstapp.model.dto;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class RestaurantDTO {

    @NonNull
    private String name;

    @NonNull
    private String address;

    @NonNull
    private Set<ZoneDTO> deliveryZones;

    @NonNull
    private AdminDTO adminDTO;
}
