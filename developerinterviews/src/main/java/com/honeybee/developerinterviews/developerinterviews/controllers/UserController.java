package com.honeybee.developerinterviews.developerinterviews.controllers;

import com.honeybee.developerinterviews.developerinterviews.entities.User;
import com.honeybee.developerinterviews.developerinterviews.entities.UserModel;
import com.honeybee.developerinterviews.developerinterviews.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

//    @PostMapping("/register")
//    public ResponseEntity<User> save(@Valid @RequestBody UserModel user) {
//        return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);
//    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/profile")
    public ResponseEntity<User> get() {
        return new ResponseEntity<>(userService.read(), HttpStatus.OK);
    }

    @PutMapping("/profile")
    public ResponseEntity<User> updateUser(@RequestBody UserModel user) {
        return new ResponseEntity<>(userService.updateUser(user), HttpStatus.OK);
    }

    @DeleteMapping("/deactivate")
    public ResponseEntity<HttpStatus> deleteUser() {
        userService.deleteUser();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
