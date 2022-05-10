package ro.sd.firstapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sd.firstapp.model.Admin;
import ro.sd.firstapp.model.UserData;
import ro.sd.firstapp.model.dto.AdminDTO;
import ro.sd.firstapp.model.mapper.AdminMapper;
import ro.sd.firstapp.repository.AdminRepo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service for admin operations
 */
@Service
public class AdminService {
    @Autowired
    private AdminRepo adminRepo;

    /**
     * Saves in the database
     * @param administrator instance to be saved
     * @return the saved administrator
     */
    public Admin save(Admin administrator) {
        Admin a = Admin.AdminBuilder()
                .username(administrator.getUsername())
                .firstName(administrator.getFirstName())
                .lastName(administrator.getLastName())
                .password(administrator.getPassword())
                .build();
        return adminRepo.save(a);
    }

    /**
     * Searches for an admin from the database by username
     * @param username of the admin
     * @return the admin
     */
    public Admin findByUsername(String username) {
        Optional<Admin> administrator = adminRepo.findByUsername(username);

        return administrator.orElse(null);
    }
}
