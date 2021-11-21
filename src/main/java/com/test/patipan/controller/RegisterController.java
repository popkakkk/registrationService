package com.test.patipan.controller;

import com.test.patipan.entity.User;
import com.test.patipan.model.AuthenticationResponse;
import com.test.patipan.services.UserAuthentication;
import com.test.patipan.services.UserRegistrationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/registration")
public class RegisterController {

    @Autowired
    private UserRegistrationService userRegistrationService;

    @Autowired
    private UserAuthentication userAuthentication;


    @PostMapping("/registerUser")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody User user) throws UsernameNotFoundException {
        userRegistrationService.saveUser(user);
        final String jwt = userAuthentication.createToken(user);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @GetMapping("/information")
    public ResponseEntity<?> information() {
        return ResponseEntity.ok(userRegistrationService.getInformation());
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> authentication(@RequestBody User user) throws Exception {
        final String jwt = userAuthentication.authenticationToken(user);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
