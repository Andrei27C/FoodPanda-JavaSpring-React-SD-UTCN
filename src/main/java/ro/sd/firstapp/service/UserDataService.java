package ro.sd.firstapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sd.firstapp.model.Admin;
import ro.sd.firstapp.model.Customer;
import ro.sd.firstapp.model.UserData;
import ro.sd.firstapp.model.dto.LoginDTO;
import ro.sd.firstapp.model.dto.UserDataDTO;
import ro.sd.firstapp.model.mapper.AdminMapper;
import ro.sd.firstapp.model.mapper.CustomerMapper;
import ro.sd.firstapp.model.mapper.UserDataMapper;
import ro.sd.firstapp.repository.AdminRepo;
import ro.sd.firstapp.repository.CustomerRepo;
import java.util.Optional;

@Service
public class UserDataService {
    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    private CustomerRepo customerRepo;

    public UserDataDTO findByUsername(String username) {
        Optional<Admin> admin = adminRepo.findByUsername(username);
        if (admin.isPresent()) {
            //delete
            System.out.println(admin);
            return admin.map(value -> AdminMapper.getInstance().convertToDTO(value)).orElse(null);
        } else {
            Optional<Customer> customer = customerRepo.findByUsername(username);
            //delete
            System.out.println(customer);
            return customer.map(value -> CustomerMapper.getInstance().convertToDTO(value)).orElse(null);
        }
    }

    public UserDataDTO getUserDataDTO(LoginDTO loginDTO) throws Exception {
        UserDataDTO userDataDTO = this.findByUsername(loginDTO.getUsername());
        if (userDataDTO == null) {
            throw new Exception("No userData found");
        }
        UserData userData = UserDataMapper.getInstance().convertFromDTO(userDataDTO);

        if (loginDTO.getPassword().equals(userData.getPassword()) ){
            return userDataDTO;
        }
        throw new Exception("Incorrect Password!");
    }

    public UserDataDTO logIn(LoginDTO loginDTO) throws Exception {
        return this.getUserDataDTO(loginDTO);
    }
}