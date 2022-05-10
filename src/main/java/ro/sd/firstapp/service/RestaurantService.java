package ro.sd.firstapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sd.firstapp.model.Admin;
import ro.sd.firstapp.model.Restaurant;
import ro.sd.firstapp.model.Zone;
import ro.sd.firstapp.model.dto.RestaurantDTO;
import ro.sd.firstapp.model.dto.ZoneDTO;
import ro.sd.firstapp.model.mapper.RestaurantMapper;
import ro.sd.firstapp.repository.RestaurantRepo;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Service used to handle the Restaurant model
 */
@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepo restaurantRepo;

    @Autowired
    private AdminService adminService;

    @Autowired
    private ZoneService zoneService;

    /**
     * Retrieves a restaurant from the database by its name.
     * @param name of the restaurant
     * @return The found restaurant.
     */
    public Restaurant findByName(String name) {
        Optional<Restaurant> restaurant = restaurantRepo.findByName(name);
        return restaurant.orElse(null);
    }

    /**
     * Saves a new restaurant to the database.
     * @param restaurantDTO containing the details of the new restaurant
     * @return The saved restaurant instance.
     */
    public RestaurantDTO save(RestaurantDTO restaurantDTO){

        Admin admin = adminService.findByUsername(restaurantDTO.getAdminDTO().getUsername());

        String address = restaurantDTO.getAddress();

        Set<Zone> zones = new HashSet<>();
        for (ZoneDTO zoneDTO : restaurantDTO.getDeliveryZones()) {
            Zone zone = zoneService.findByName(zoneDTO.getName());
            if (zone != null) {
                zones.add(zone);
            }
        }

        Restaurant restaurant = Restaurant.builder()
                .name(restaurantDTO.getName())
                .address(address)
                .admin(admin)
                .deliveryZones(zones)
                .build();

        return RestaurantMapper.getInstance().convertToDTO(restaurantRepo.save(restaurant));
    }

    /**
     * Retrieves all restaurants from the database.
     * @return A List containing all restaurants.
     */
    public List<RestaurantDTO> findAll() {
        return restaurantRepo.findAll().stream()
                .map(RestaurantMapper.getInstance()::convertToDTO)
                .collect(Collectors.toList());
    }



}
