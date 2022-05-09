package ro.sd.firstapp.model.mapper;

import ro.sd.firstapp.model.Restaurant;
import ro.sd.firstapp.model.dto.RestaurantDTO;

import java.util.stream.Collectors;

public class RestaurantMapper implements Mapper<Restaurant, RestaurantDTO> {

    private static RestaurantMapper restaurantMapper = null;

    private RestaurantMapper() { }

    public static RestaurantMapper getInstance() {
        if (restaurantMapper == null) {
            restaurantMapper = new RestaurantMapper();
        }
        return restaurantMapper;
    }

    @Override
    public Restaurant convertFromDTO(RestaurantDTO restaurantDTO) {
        return null;
    }

    @Override
    public RestaurantDTO convertToDTO(Restaurant restaurant) {
        return RestaurantDTO.builder()
                .name(restaurant.getName())
                .address(restaurant.getAddress())
                .deliveryZones(restaurant.getDeliveryZones().stream()
                        .map(ZoneMapper.getInstance()::convertToDTO)
                        .collect(Collectors.toSet()))
                .adminDTO(AdminMapper.getInstance().convertToDTO(restaurant.getAdmin()))
                .build();
    }
}
