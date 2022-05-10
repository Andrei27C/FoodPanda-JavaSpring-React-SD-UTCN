package ro.sd.firstapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sd.firstapp.model.Customer;
import ro.sd.firstapp.model.dto.CustomerDTO;
import ro.sd.firstapp.model.mapper.CustomerMapper;
import ro.sd.firstapp.repository.CustomerRepo;

import java.util.Optional;

/**
 * Service for customer operations
 */
@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    /**
     * Searches for an customer in the database by username
     * @param username of the customer
     * @return the found customer
     */
    public Customer findByUsername(String username) {
        Optional<Customer> customer = customerRepo.findByUsername(username);

        return customer.orElse(null);
    }

    /**
     * Registers a customer
     * @param customerDTO, the details of the customer
     * @return the registered customer
     */
    public CustomerDTO register(CustomerDTO customerDTO) {
        Customer c = CustomerMapper.getInstance().convertFromDTO(customerDTO);
        customerRepo.save(c);

        return CustomerMapper.getInstance().convertToDTO(c);
    }
}
