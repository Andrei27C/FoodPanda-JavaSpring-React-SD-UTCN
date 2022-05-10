package ro.sd.firstapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sd.firstapp.model.Food;
import ro.sd.firstapp.model.Restaurant;
import ro.sd.firstapp.model.dto.FoodDTO;
import ro.sd.firstapp.model.mapper.FoodMapper;
import ro.sd.firstapp.repository.FoodRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service used to handle the Food model
 */
@Service
public class FoodService {

    @Autowired
    private FoodRepo foodRepo;

    @Autowired
    private RestaurantService restaurantService;

    private final static Logger logger = LoggerFactory.getLogger(FoodService.class.getName());

    /**
     * Retrieves a food item by restaurant.
     * @param restaurantName of the restaurant from which the food belongs to
     * @return the retrieved food
     */
    public List<FoodDTO> findByRestaurant(String restaurantName){
        Restaurant restaurant = restaurantService.findByName(restaurantName);
        Optional<List<Food>> foods = Optional.ofNullable(foodRepo.findByRestaurant(restaurant));
        logger.info("Find foods by restaurant: {}", restaurantName);
        return foods.map(foodList -> foodList.stream()
                .map(FoodMapper.getInstance()::convertToDTO)
                .collect(Collectors.toList())).orElseGet(ArrayList::new);
    }

    /**
     * Retrieves all food items.
     * @return A List containing all the retrieved food
     */
    public List<FoodDTO> findAll(){
        Optional<List<Food>> foods = Optional.ofNullable(foodRepo.findAll());
        logger.info("Find all foods");

        return foods.map(foodList -> foodList.stream()
                .map(FoodMapper.getInstance()::convertToDTO)
                .collect(Collectors.toList())).orElseGet(ArrayList::new);
    }


    /**
     * Saves a food item to the database.
     * @param foodDTO containing the details of the food
     * @return The saved instance of the food item.
     */
    public FoodDTO save(FoodDTO foodDTO){
        Restaurant restaurant = restaurantService.findByName(foodDTO.getRestaurantDTO().getName());
        logger.info("Save food {} to database", foodDTO.getName());

        Food food = Food.builder()
                .name(foodDTO.getName())
                .price(foodDTO.getPrice())
                .description(foodDTO.getDescription())
                .category(foodDTO.getCategory())
                .restaurant(restaurant)
                .build();

        return FoodMapper.getInstance().convertToDTO(foodRepo.save(food));
    }


}
