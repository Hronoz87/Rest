package ru.netology.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.netology.exciption.InvalidCredentials;
import ru.netology.service.Authorities;
import ru.netology.service.AuthorizationService;

import java.util.List;

@RestController
@RequestMapping("/")
public class AuthorizationController {
    AuthorizationService service;

    @Autowired
    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }

    @ExceptionHandler(RuntimeException.class)
    ResponseEntity<String> InvalidCredentialsEx(InvalidCredentials e) {
        return new ResponseEntity<>("User name or password is empty" + e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    ResponseEntity<String> UnauthorizedUserEx(InvalidCredentials e) {
        return new ResponseEntity<>("Unknown user "  + e.getMessage(), HttpStatus.UNAUTHORIZED);
    }
}
