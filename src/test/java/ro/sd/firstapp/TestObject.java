package ro.sd.firstapp;

import ro.sd.firstapp.model.*;
import ro.sd.firstapp.model.dto.FoodDTO;
import ro.sd.firstapp.model.dto.UserDataDTO;
import ro.sd.firstapp.model.mapper.FoodMapper;

import java.util.HashSet;
import java.util.Set;

public class TestObject {
    public UserDataDTO createTestUserDataDTO() {
        return UserDataDTO.builder()
                .username("cscs")
                .firstName("Andrei")
                .lastName("Cs")
                .password("parolaparola123")
                .build();
    }

    public Admin createTestAdmin() {
        UserDataDTO accountDTO = createTestUserDataDTO();
        Admin admin = Admin.AdminBuilder()
                .username(accountDTO.getUsername())
                .firstName(accountDTO.getFirstName())
                .lastName(accountDTO.getLastName())
                .password(accountDTO.getPassword())
                .build();
        admin.setIdUser(1);
        return admin;
    }

    public Customer createTestCustomer() {
        UserDataDTO accountDTO = createTestUserDataDTO();
        Customer customer = Customer.CustomerBuilder()
                .username(accountDTO.getUsername())
                .firstName(accountDTO.getFirstName())
                .lastName(accountDTO.getLastName())
                .password(accountDTO.getPassword())
                .address("address")
                .build();
        customer.setIdUser(1);
        return customer;
    }

    public Zone createTestZone() {
        return Zone.builder()
                .idZone(1)
                .name("zx")
                .build();
    }

    public Set<Zone> createTestDeliveryZones() {
        Set<Zone> zones = new HashSet<>();
        zones.add(createTestZone());
        zones.add(Zone.builder().idZone(2).name("zy").build());
        zones.add(Zone.builder().idZone(3).name("zz").build());
        return zones;
    }

    public Restaurant createTestRestaurant() {
        return Restaurant.builder()
                .idRestaurant(1)
                .admin(createTestAdmin())
                .name("Restaurant")
                .deliveryZones(createTestDeliveryZones())
                .address("address")
                .build();
    }

    public Food createTestFood() {
        return Food.builder()
                .idFood(1)
                .name("TestDessert")
                .price(99)
                .description("short description")
                .category(FoodCategory.builder().idCategory(1).name("DESSERT").build())
                .restaurant(createTestRestaurant())
                .build();
    }

    public FoodDTO createTestFoodDTO() {
        return FoodMapper.getInstance().convertToDTO(createTestFood());
    }

}
