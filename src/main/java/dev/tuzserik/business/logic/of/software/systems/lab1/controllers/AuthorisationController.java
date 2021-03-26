package dev.tuzserik.business.logic.of.software.systems.lab1.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import dev.tuzserik.business.logic.of.software.systems.lab1.services.AuthorisationService;
import dev.tuzserik.business.logic.of.software.systems.lab1.requests.UserRegistrationRequest;
import dev.tuzserik.business.logic.of.software.systems.lab1.responses.UserInformationResponse;
import dev.tuzserik.business.logic.of.software.systems.lab1.model.User;

@AllArgsConstructor @RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class AuthorisationController {
    private final AuthorisationService authorisationService;

    @GetMapping("/api/user")
    ResponseEntity<UserInformationResponse> getUser() {
        String login = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = authorisationService.findUserByLogin(login);

        if (user != null) {
            return new ResponseEntity<>(new UserInformationResponse(
                    user.getLogin(), user.getGivenName(), user.getFamilyName()),
                    HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/api/user")
    ResponseEntity<UserInformationResponse> registerUser(@RequestBody UserRegistrationRequest request) {
        User user = authorisationService.saveUser(new User()
                .setLogin(request.getLogin())
                .setPassword(request.getPassword())
                .setGivenName(request.getGivenName())
                .setFamilyName(request.getFamilyName()));

        return new ResponseEntity<>(new UserInformationResponse(
                user.getLogin(), user.getGivenName(), user.getFamilyName()),
                HttpStatus.OK);
    }
}
