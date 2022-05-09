package ro.sd.firstapp.model.mapper;

import ro.sd.firstapp.model.Customer;
import ro.sd.firstapp.model.dto.CustomerDTO;

public class CustomerMapper implements Mapper<Customer, CustomerDTO> {
    private static CustomerMapper customerMapper = null;

    private CustomerMapper() { }

    public static CustomerMapper getInstance() {
        if (customerMapper == null) {
            customerMapper = new CustomerMapper();
        }
        return customerMapper;
    }

    @Override
    public Customer convertFromDTO(CustomerDTO customerDTO) {
        return Customer.CustomerBuilder()
                .address(customerDTO.getAddress())
                .username(customerDTO.getUsername())
                .firstName(customerDTO.getFirstName())
                .lastName(customerDTO.getLastName())
                .password(customerDTO.getPassword())
                .build();
    }

    @Override
    public CustomerDTO convertToDTO(Customer customer) {
        return CustomerDTO.CustomerDTOBuilder()
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .username(customer.getUsername())
                .address(customer.getAddress())
                .password(customer.getPassword())
                .build();
    }


}
