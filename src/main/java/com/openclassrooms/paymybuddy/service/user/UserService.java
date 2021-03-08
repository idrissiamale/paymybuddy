package com.openclassrooms.paymybuddy.service.user;

import com.openclassrooms.paymybuddy.exception.BadArgumentException;
import com.openclassrooms.paymybuddy.exception.ResourceNotFoundException;
import com.openclassrooms.paymybuddy.model.User;
import com.openclassrooms.paymybuddy.web.dto.UserRegistrationDto;

import java.util.List;

public interface UserService {
    User saveUser(UserRegistrationDto userRegistrationDto);

    List<User> findAll();

    User findById(Integer id) throws ResourceNotFoundException;

    User findByEmail(String email) throws ResourceNotFoundException;

    User findByEmailAndPassword(String email, String password);

    User save(User user) throws BadArgumentException;

    List<User> saveAll(List<User> users);

    User update(Integer id, User user);

    void deleteById(Integer id);
}
