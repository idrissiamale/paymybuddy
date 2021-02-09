package com.openclassrooms.paymybuddy.service;

import com.openclassrooms.paymybuddy.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    User getUserById(int id);

    User getUserByEmail(String email);

    User getUserByEmailAndPassword(String email, String password);

    User saveUser(User user);

    List<User> saveUsers(List<User> users);

    User updateUser(User user);

    void deleteUser(int id);
}
