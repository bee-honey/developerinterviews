package com.honeybee.developerinterviews.developerinterviews.services;

import com.honeybee.developerinterviews.developerinterviews.entities.User;
import com.honeybee.developerinterviews.developerinterviews.entities.UserModel;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    User createUser(UserModel user);

    User read();

    User updateUser(UserModel user);

    void deleteUser();

    User getLoggedInUser();
}
