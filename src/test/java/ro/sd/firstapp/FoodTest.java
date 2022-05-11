package ro.sd.firstapp;


import ro.sd.firstapp.model.Food;
import ro.sd.firstapp.model.Restaurant;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import ro.sd.firstapp.model.dto.FoodDTO;
import ro.sd.firstapp.repository.FoodRepo;
import ro.sd.firstapp.service.FoodService;
import ro.sd.firstapp.service.RestaurantService;

import static org.mockito.AdditionalAnswers.returnsFirstArg;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class FoodTest {
    @Mock
    private FoodRepo foodRepo;

    @Mock
    private RestaurantService restaurantService;

    @InjectMocks
    private FoodService foodService;

    private final TestObject testObject = new TestObject();

    @Test
    public void testSave() {
        Food food = testObject.createTestFood();
        FoodDTO foodDTO = testObject.createTestFoodDTO();

        Mockito.when(restaurantService.findByName(Mockito.anyString())).thenReturn(food.getRestaurant());
        Mockito.when(foodRepo.findByNameAndRestaurant(Mockito.anyString(), Mockito.any(Restaurant.class)))
                .thenReturn(Optional.empty());

        Mockito.when(foodRepo.save(Mockito.any(Food.class))).then(returnsFirstArg());

        Assertions.assertDoesNotThrow(() -> foodService.save(foodDTO));
    }

    @Test
    public void testSaveNoRestaurant() {
        FoodDTO foodDTO = testObject.createTestFoodDTO();

        Mockito.when(restaurantService.findByName(Mockito.anyString())).thenReturn(null);

        Assertions.assertThrows(Exception.class, () -> foodService.save(foodDTO));
    }

    @Test
    public void testSaveDuplicateFood() {
        Food food = testObject.createTestFood();
        FoodDTO foodDTO = testObject.createTestFoodDTO();

        Mockito.when(restaurantService.findByName(Mockito.anyString())).thenReturn(food.getRestaurant());
        Mockito.when(foodRepo.findByNameAndRestaurant(Mockito.anyString(), Mockito.any(Restaurant.class)))
                .thenReturn(Optional.of(food));

        Assertions.assertThrows(Exception.class, () -> foodService.save(foodDTO));
    }

}

