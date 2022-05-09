package ro.sd.firstapp.model.mapper;

import ro.sd.firstapp.model.Admin;
import ro.sd.firstapp.model.dto.AdminDTO;

public class AdminMapper implements Mapper<Admin, AdminDTO> {
    private static AdminMapper adminMapper = null;

    private AdminMapper() { }

    public static AdminMapper getInstance() {
        if (adminMapper == null) {
            adminMapper = new AdminMapper();
        }
        return adminMapper;
    }

    @Override
    public Admin convertFromDTO(AdminDTO adminDTO) {
        return null;
    }

    @Override
    public AdminDTO convertToDTO(Admin admin) {
        return AdminDTO.AdminDTOBuilder()
                .firstName(admin.getFirstName())
                .lastName(admin.getLastName())
                .username(admin.getUsername())
                .password(admin.getPassword())
                .restaurant(admin.getRestaurant())
                .build();
    }
}
