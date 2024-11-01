package com.honeybee.developerinterviews.developerinterviews.controllers;

import com.honeybee.developerinterviews.developerinterviews.entities.AuthModel;
import com.honeybee.developerinterviews.developerinterviews.entities.AuthResponse;
import com.honeybee.developerinterviews.developerinterviews.entities.User;
import com.honeybee.developerinterviews.developerinterviews.entities.UserModel;
import com.honeybee.developerinterviews.developerinterviews.security.CustomUserDetails;
import com.honeybee.developerinterviews.developerinterviews.security.CustomUserDetailsService;
import com.honeybee.developerinterviews.developerinterviews.services.UserService;
import com.honeybee.developerinterviews.developerinterviews.utils.JwtTokenUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthModel authModel) throws Exception {

        authenticate(authModel.getEmail(), authModel.getPassword());

        // we need to generate the JWT token
        final CustomUserDetails userDetails = (CustomUserDetails) customUserDetailsService.loadUserByUsername(authModel.getEmail());
        System.out.println("NKK: Authenticated : " + userDetails.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);
        System.out.println("NKK: Token: " + token);

        return new ResponseEntity<AuthResponse>(new AuthResponse(userDetails.getUserId(), token), HttpStatus.OK);
    }

    private void authenticate(String email, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        } catch (DisabledException e) {
            throw new Exception("User Disabled");
        } catch (BadCredentialsException e) {
            throw new Exception("Bad Creds");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<User> save(@Valid @RequestBody UserModel user) {
        return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);
    }


}
