package com.openclassrooms.paymybuddy.service.user;

import com.openclassrooms.paymybuddy.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(Integer id);

    User findByEmail(String email);

    User findByEmailAndPassword(String email, String password);

    User save(User user);

    List<User> saveAll(List<User> users);

    User update(Integer id, User user);

    String deleteById(Integer id);
}
