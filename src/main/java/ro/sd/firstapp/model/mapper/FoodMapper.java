package ro.sd.firstapp.model.mapper;

import ro.sd.firstapp.model.Food;
import ro.sd.firstapp.model.dto.FoodDTO;

public class FoodMapper implements Mapper<Food, FoodDTO> {

    private static FoodMapper foodMapper = null;

    private FoodMapper() { }

    public static FoodMapper getInstance() {
        if (foodMapper == null) {
            foodMapper = new FoodMapper();
        }
        return foodMapper;
    }

    @Override
    public Food convertFromDTO(FoodDTO foodDTO) {
        return null;
    }

    @Override
    public FoodDTO convertToDTO(Food food) {
        return FoodDTO.builder()
                .name(food.getName())
                .price(food.getPrice())
                .description(food.getDescription())
                .category(food.getCategory())
                .restaurantDTO(RestaurantMapper.getInstance().convertToDTO(food.getRestaurant()))
                .build();
    }
}
