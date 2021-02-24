package com.openclassrooms.paymybuddy.controller;

import com.openclassrooms.paymybuddy.model.Credit;
import com.openclassrooms.paymybuddy.service.transaction.credit.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CreditController {
    @Autowired
    private CreditService creditService;

    @GetMapping("credits/{id}")
    public Credit findById(@PathVariable Integer id) {
        return creditService.findById(id);
    }

    @GetMapping("users/{userId}/credits")
    public List<Credit> findByUserId(@PathVariable Integer userId) {
        return creditService.findByUserId(userId);
    }

    @GetMapping("/credits")
    public List<Credit> findAll() {
        return creditService.findAllCredits();
    }

    @PostMapping("/users/{userId}/credits")
    public Credit save(@PathVariable Integer userId, @RequestBody Credit credit) {
        return creditService.save(userId, credit);
    }


    @PutMapping("/credits/{creditId}")
    public Credit update(@PathVariable Integer creditId, @RequestBody Credit credit) {
        return creditService.update(creditId, credit);
    }

    @PutMapping("/users/{userId}/credits/{creditId}")
    public Credit updateUserCredit(@PathVariable Integer userId, @PathVariable Integer creditId, @RequestBody Credit credit) {
        return creditService.updateUserCredit(userId, creditId, credit);
    }

    @DeleteMapping("/credits/{creditId}")
    public void delete(@PathVariable Integer creditId) {
        creditService.delete(creditId);
    }

    @DeleteMapping("/users/{userId}/credits/{creditId}")
    public String deleteUserCredit(@PathVariable Integer userId, @PathVariable Integer creditId) {
        return creditService.deleteUserCredit(userId, creditId);
    }
}

