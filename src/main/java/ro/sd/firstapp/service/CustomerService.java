package ro.sd.firstapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sd.firstapp.model.Customer;
import ro.sd.firstapp.model.dto.CustomerDTO;
import ro.sd.firstapp.model.mapper.CustomerMapper;
import ro.sd.firstapp.repository.CustomerRepo;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    public Customer findByUsername(String email) {
        Optional<Customer> customer = customerRepo.findByUsername(email);

        return customer.orElse(null);
    }

    public CustomerDTO register(CustomerDTO customerDTO) {
        Customer c = CustomerMapper.getInstance().convertFromDTO(customerDTO);
        customerRepo.save(c);

        return CustomerMapper.getInstance().convertToDTO(c);
    }
}
