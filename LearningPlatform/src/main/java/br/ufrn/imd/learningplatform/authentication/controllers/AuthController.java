package br.ufrn.imd.learningplatform.authentication.controllers;

import br.ufrn.imd.learningplatform.authentication.model.dto.login.LoginRequest;
import br.ufrn.imd.learningplatform.authentication.model.dto.register.RegisterRequest;
import br.ufrn.imd.learningplatform.authentication.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
       return authService.authenticateUser(loginRequest);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest registerRequest) {
        return authService.registerUser(registerRequest);
    }

    @PreAuthorize("hasRole('ORGANIZATION')")
    @GetMapping("/users")
    public String logi2n() {
        return "Greetings from Spring Boot!";
    }
}
