package ro.sd.firstapp;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import ro.sd.firstapp.model.Admin;
import ro.sd.firstapp.model.Customer;
import ro.sd.firstapp.model.dto.LoginDTO;
import ro.sd.firstapp.model.dto.UserDataDTO;
import ro.sd.firstapp.repository.AdminRepo;
import ro.sd.firstapp.repository.CustomerRepo;
import ro.sd.firstapp.service.UserDataService;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class UserDataServiceTest {
    @Mock
    private AdminRepo administratorRepo;

    @Mock
    private CustomerRepo customerRepo;

    @InjectMocks
    private UserDataService userDataService;

    private final TestObject dummy = new TestObject();

    @Test
    public void testFindByUsernameAdmin() {
        Admin administrator = dummy.createTestAdmin();

        Mockito.when(administratorRepo.findByUsername(administrator.getUsername())).thenReturn(Optional.of(administrator));

        UserDataDTO foundUserDataDTO = userDataService.findByUsername(administrator.getUsername());

        Assertions.assertEquals(administrator.getUsername(), foundUserDataDTO.getUsername());

    }

    @Test
    public void testFindByUsernameCustomer() {
        Customer customer = dummy.createTestCustomer();

        Mockito.when(administratorRepo.findByUsername(customer.getUsername())).thenReturn(Optional.empty());
        Mockito.when(customerRepo.findByUsername(customer.getUsername())).thenReturn(Optional.of(customer));

        UserDataDTO foundUserDataDTO = userDataService.findByUsername(customer.getUsername());

        Assertions.assertEquals(customer.getUsername(), foundUserDataDTO.getUsername());
    }

    @Test(expected = Exception.class)
    public void testLoginNoUserData() throws Exception {
        Admin administrator = dummy.createTestAdmin();

        Mockito.when(administratorRepo.findByUsername(administrator.getUsername())).thenReturn(Optional.empty());
        Mockito.when(customerRepo.findByUsername(administrator.getUsername())).thenReturn(Optional.empty());

        userDataService.logIn(new LoginDTO(administrator.getUsername(), administrator.getPassword()));
    }
}
