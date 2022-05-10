package ro.sd.firstapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private final static Logger logger = LoggerFactory.getLogger(AdminService.class.getName());

    /**
     * Saves in the database
     * @param administrator instance to be saved
     * @return the saved administrator
     */
    public Admin save(Admin administrator) {
        logger.info("Admin {} saved to database", administrator);
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
        logger.info("Retrieve administrator: {} from the database", username);

        Optional<Admin> administrator = adminRepo.findByUsername(username);

        return administrator.orElse(null);
    }
}
