package com.openclassrooms.paymybuddy.service.user;

import com.openclassrooms.paymybuddy.exception.ResourceNotFoundException;
import com.openclassrooms.paymybuddy.model.User;
import com.openclassrooms.paymybuddy.web.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto userRegistrationDto);

    List<User> findAll();

    User findById(Integer id) throws ResourceNotFoundException;


    List<User> saveAll(List<User> users);

    User update(Integer id, User user);

    void deleteById(Integer id);
}
