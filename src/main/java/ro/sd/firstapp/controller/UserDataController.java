package ro.sd.firstapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.sd.firstapp.model.dto.LoginDTO;
import ro.sd.firstapp.model.dto.UserDataDTO;
import ro.sd.firstapp.service.*;


@RestController
@RequestMapping("/login")
public class UserDataController {

    @Autowired
    private UserDataService userDataService;

    @PostMapping("")
    public ResponseEntity<UserDataDTO> login(@RequestBody(required = false) LoginDTO loginDTO) throws Exception {
        System.out.println("a ajuns aici");
        return new ResponseEntity<>(userDataService.logIn(loginDTO), HttpStatus.CREATED);
    }
}
