package ro.sd.firstapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.sd.firstapp.model.FoodCategory;
import ro.sd.firstapp.model.Zone;
import ro.sd.firstapp.model.dto.AdminDTO;
import ro.sd.firstapp.model.dto.FoodDTO;
import ro.sd.firstapp.model.dto.RestaurantDTO;
import ro.sd.firstapp.model.mapper.AdminMapper;
import ro.sd.firstapp.service.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService AdminService;

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private FoodCategoryService foodCategoryService;

    @Autowired
    private ZoneService zoneService;

    @Autowired
    private FoodService foodService;

    @GetMapping("/get")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public AdminDTO getCurrentAdmin(@Param("adminUsername") String adminUsername) {
        return AdminMapper.getInstance().convertToDTO(AdminService.findByUsername(adminUsername));
    }

    @GetMapping("/addRestaurant")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<List<Zone>> getZones() {
        try {
            return new ResponseEntity<>(zoneService.findAll(), HttpStatus.ACCEPTED);
        } catch (Exception exception) {
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PostMapping("/addRestaurant")
    public ResponseEntity<RestaurantDTO> addRestaurant(@RequestBody(required = false) RestaurantDTO restaurantDTO) {
        return new ResponseEntity<>(restaurantService.save(restaurantDTO), HttpStatus.CREATED);
    }

    @GetMapping("/addFood")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<List<FoodCategory>> getFoodCategories() {
        //System.out.println(foodCategoryService.findAll());
        return new ResponseEntity<>(foodCategoryService.findAll(), HttpStatus.ACCEPTED);
    }

    @PostMapping("/addFood")
    public ResponseEntity<FoodDTO> addFood(@RequestBody(required = false) FoodDTO foodDTO) {
        return new ResponseEntity<>(foodService.save(foodDTO), HttpStatus.CREATED);
    }

    @GetMapping("/viewMenu")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<List<FoodDTO>> getFoods(@Param("restaurantName") String restaurantName) {
        return new ResponseEntity<>(foodService.findByRestaurant(restaurantName), HttpStatus.ACCEPTED);
    }
}
