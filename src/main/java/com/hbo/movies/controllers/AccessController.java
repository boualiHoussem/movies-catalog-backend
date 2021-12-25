package com.hbo.movies.controllers;

import com.hbo.movies.common.JwtUtils;
import com.hbo.movies.common.models.LoginModel;
import com.hbo.movies.common.models.LoginResponse;
import com.hbo.movies.entities.User;
import com.hbo.movies.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Houssem BOUALI
 * date: 24/12/2021
 */
@RestController
@RequestMapping("/access")
public class AccessController {

    private final AuthenticationManager authManager;
    private final JwtUtils tokenUtils;
    private final UserDetailsService userDetailsService;
    private final UserService userService;

    @Autowired
    public AccessController(AuthenticationManager authManager,
                            JwtUtils tokenUtils,
                            @Qualifier("userDetailsServiceImpl") UserDetailsService userDetailsService,
                            UserService userService) {
        this.authManager = authManager;
        this.tokenUtils = tokenUtils;
        this.userDetailsService = userDetailsService;
        this.userService = userService;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginModel login) throws Exception {
        authenticate(login.getUsername(), login.getPassword());
        final UserDetails userDetails = userDetailsService.loadUserByUsername(login.getUsername());
        final String token = tokenUtils.generateToken(userDetails);
        User userByUsername = userService.findUserByUsername(login.getUsername());
        LoginResponse loginResponse = new LoginResponse(token);
        loginResponse.getUser().setId(userByUsername.getId());
        loginResponse.getUser().setFirstName(userByUsername.getFirstName());
        loginResponse.getUser().setLastName(userByUsername.getLastName());
        loginResponse.getUser().setUsername(userByUsername.getUsername());
        return ResponseEntity.ok(loginResponse);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        if (userService.registerUser(user)) {
            return ResponseEntity.ok("User Created");
        }
        return ResponseEntity.badRequest().body("Username already in use");
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(HttpServletRequest request) {
        final String token;
        String authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            token = authorizationHeader.substring(7);
            SecurityContext securityContext = SecurityContextHolder.getContext();
            UserDetails principal = (UserDetails) securityContext.getAuthentication().getPrincipal();
            if (tokenUtils.validateToken(token, principal)) {
                securityContext.setAuthentication(null);
            }
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    private void authenticate(String username, String password) throws AuthenticationException {
        try {
            authManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (BadCredentialsException bce) {
            throw new BadCredentialsException("Invalid credentials", bce);
        }
    }


}
