package ro.sd.firstapp.service;

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

@Service
public class FoodService {

    @Autowired
    private FoodRepo foodRepo;

    @Autowired
    private RestaurantService restaurantService;


    public List<FoodDTO> findByRestaurant(String restaurantName){
        Restaurant restaurant = restaurantService.findByName(restaurantName);


        Optional<List<Food>> foods = Optional.ofNullable(foodRepo.findByRestaurant(restaurant));

        return foods.map(foodList -> foodList.stream()
                .map(FoodMapper.getInstance()::convertToDTO)
                .collect(Collectors.toList())).orElseGet(ArrayList::new);
    }

    public List<FoodDTO> findAll(){
        Optional<List<Food>> foods = Optional.ofNullable(foodRepo.findAll());

        return foods.map(foodList -> foodList.stream()
                .map(FoodMapper.getInstance()::convertToDTO)
                .collect(Collectors.toList())).orElseGet(ArrayList::new);
    }



    public FoodDTO save(FoodDTO foodDTO){
        Restaurant restaurant = restaurantService.findByName(foodDTO.getRestaurantDTO().getName());

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
