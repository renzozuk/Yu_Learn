package br.ufrn.imd.learningplatform.authentication.services;

import br.ufrn.imd.learningplatform.authentication.model.dto.login.LoginRequest;
import br.ufrn.imd.learningplatform.authentication.model.dto.login.LoginResponse;
import br.ufrn.imd.learningplatform.authentication.model.dto.register.RegisterRequest;
import br.ufrn.imd.learningplatform.authentication.model.dto.register.RegisterResponse;
import br.ufrn.imd.learningplatform.authentication.model.entities.User;
import br.ufrn.imd.learningplatform.authentication.model.enums.Role;
import br.ufrn.imd.learningplatform.authentication.repositories.UserRepository;
import br.ufrn.imd.learningplatform.config.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AuthService {

    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthService(JwtUtils jwtUtils, AuthenticationManager authenticationManager, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.jwtUtils = jwtUtils;
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public ResponseEntity<?> authenticateUser(LoginRequest loginRequest) {
        Authentication authentication;

        try {
            authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        } catch (AuthenticationException exception) {

            Map<String, Object> map = new HashMap<>();
            map.put("message", "Bad credentials");
            map.put("status", false);
            return new ResponseEntity<Object>(map, HttpStatus.UNAUTHORIZED);
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        String jwtToken = jwtUtils.generateTokenFromUsername(userDetails);

        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        LoginResponse response = new LoginResponse(userDetails.getUsername(), jwtToken, roles);

        return ResponseEntity.ok(response);
    }

    public ResponseEntity<?> registerUser(RegisterRequest registerRequest) {

        try {
            User user = mountUser(registerRequest);

            userRepository.save(user);

            List<String> roles = user.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());

            RegisterResponse registerResponse = new RegisterResponse(user.getName(), user.getEmail(), roles);
            return ResponseEntity.ok(registerResponse);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private User mountUser(RegisterRequest registerRequest) {

        String name = registerRequest.getName();
        String email = registerRequest.getEmail();
        String encryptedPassword = passwordEncoder.encode(registerRequest.getPassword());

        var role = Role.valueOf(registerRequest.getRole());

        return new User(name, email, encryptedPassword, role);
    }
}
