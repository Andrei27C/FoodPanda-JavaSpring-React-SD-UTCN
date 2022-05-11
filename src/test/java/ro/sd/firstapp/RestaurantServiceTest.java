package ro.sd.firstapp;


import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import ro.sd.firstapp.model.Restaurant;
import ro.sd.firstapp.model.Zone;
import ro.sd.firstapp.model.mapper.RestaurantMapper;
import ro.sd.firstapp.repository.RestaurantRepo;
import ro.sd.firstapp.service.AdminService;
import ro.sd.firstapp.service.RestaurantService;
import ro.sd.firstapp.service.ZoneService;

import java.util.Optional;

import static org.mockito.AdditionalAnswers.returnsFirstArg;

@RunWith(MockitoJUnitRunner.class)
public class RestaurantServiceTest {
    @Mock
    private RestaurantRepo restaurantRepo;

    @Mock
    private AdminService administratorService;

    @Mock
    private ZoneService zoneService;

    @InjectMocks
    private RestaurantService restaurantService;

    private final TestObject testObject = new TestObject();

    @Test
    public void testSaveSuccess() {
        Restaurant restaurant = testObject.createTestRestaurant();

        Mockito.when(restaurantRepo.findByName(Mockito.anyString())).thenReturn(Optional.empty());
        Mockito.when(administratorService.findByUsername(Mockito.anyString())).thenReturn(restaurant.getAdmin());

        for (Zone zone : restaurant.getDeliveryZones()) {
            Mockito.when(zoneService.findByName(zone.getName())).thenReturn(zone);
        }

        Mockito.when(restaurantRepo.save(Mockito.any(Restaurant.class))).then(returnsFirstArg());

        Assertions.assertDoesNotThrow(() -> restaurantService.save(RestaurantMapper.getInstance().convertToDTO(restaurant)));
    }

    @Test
    public void testSaveNoAdmin() {
        Restaurant restaurant = testObject.createTestRestaurant();

        Mockito.when(restaurantRepo.findByName(Mockito.anyString())).thenReturn(Optional.empty());
        Mockito.when(administratorService.findByUsername(Mockito.anyString())).thenReturn(null);

        Assertions.assertThrows(Exception.class, () -> restaurantService.save(RestaurantMapper.getInstance().convertToDTO(restaurant)));
    }

    @Test
    public void testSaveDuplicateName() {
        Restaurant restaurant = testObject.createTestRestaurant();

        Mockito.when(restaurantRepo.findByName(Mockito.anyString())).thenReturn(Optional.of(restaurant));

        Assertions.assertThrows(Exception.class, () -> restaurantService.save(RestaurantMapper.getInstance().convertToDTO(restaurant)));
    }

}
