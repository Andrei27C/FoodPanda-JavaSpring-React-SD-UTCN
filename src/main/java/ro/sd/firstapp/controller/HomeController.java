package ro.sd.firstapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String getAdmins() {
        return "Hello there!";
    }
}