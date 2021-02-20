package com.openclassrooms.paymybuddy.controller;

import com.openclassrooms.paymybuddy.model.Account;
import com.openclassrooms.paymybuddy.service.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/users/{userId}/account")
    public Account saveAccount(@PathVariable Integer userId, @RequestBody Account account) {
        return accountService.save(userId, account);
    }

    @GetMapping("/accounts")
    public List<Account> getAllAccounts() {
        return accountService.findAll();
    }
    @GetMapping("/users/{userId}/account")
    public Account findUserById(@PathVariable Integer userId) {
        return accountService.findByUserId(userId);
    }
}
