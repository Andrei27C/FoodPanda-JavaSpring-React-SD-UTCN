package ro.sd.firstapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.sd.firstapp.model.dto.CustomerDTO;
import ro.sd.firstapp.model.dto.FoodDTO;
import ro.sd.firstapp.model.dto.RestaurantDTO;
import ro.sd.firstapp.model.mapper.CustomerMapper;
import ro.sd.firstapp.service.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private FoodService foodService;

    @PostMapping("/register")
    public ResponseEntity<CustomerDTO> registerCustomer(@RequestBody(required = false) CustomerDTO customerDTO) throws Exception {
        return new ResponseEntity<>(customerService.register(customerDTO), HttpStatus.CREATED);
    }

    @GetMapping("/get")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public CustomerDTO getCurrentCustomer(@Param("customerUsername") String customerUsername) {
        return CustomerMapper.getInstance().convertToDTO(customerService.findByUsername(customerUsername));
    }

    @GetMapping("/viewRestaurants")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<List<RestaurantDTO>> findRestaurants() {
        return new ResponseEntity<>(restaurantService.findAll(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/viewMenu")
    public ResponseEntity<List<FoodDTO>> getFoods(){
        return new ResponseEntity<>(foodService.findAll(), HttpStatus.ACCEPTED);
    }

}
