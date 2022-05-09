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

@Service
public class AdminService {
    @Autowired
    private AdminRepo adminRepo;

    public Admin save(Admin administrator) {
        Admin a = Admin.AdminBuilder()
                .username(administrator.getUsername())
                .firstName(administrator.getFirstName())
                .lastName(administrator.getLastName())
                .password(administrator.getPassword())
                .build();
        return adminRepo.save(a);
    }

    public Admin findByUsername(String username) {
        Optional<Admin> administrator = adminRepo.findByUsername(username);

        return administrator.orElse(null);
    }
}
