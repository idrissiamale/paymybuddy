package com.openclassrooms.paymybuddy.controller;

import com.openclassrooms.paymybuddy.exception.BadArgumentException;
import com.openclassrooms.paymybuddy.model.User;
import com.openclassrooms.paymybuddy.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private UserService userService;

    @PostMapping
    public String saveUser(@RequestBody User user) throws BadArgumentException {
        userService.save(user);
        return "User added successfully !";
    }
}
