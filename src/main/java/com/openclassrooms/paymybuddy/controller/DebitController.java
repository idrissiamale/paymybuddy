package com.openclassrooms.paymybuddy.controller;

import com.openclassrooms.paymybuddy.model.Debit;
import com.openclassrooms.paymybuddy.service.transaction.debit.DebitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DebitController {
    @Autowired
    private DebitService debitService;

    @GetMapping("debits/{id}")
    public Debit findById(@PathVariable Integer id) {
        return debitService.findById(id);
    }

    @GetMapping("users/{userId}/debits")
    public List<Debit> findByUserId(@PathVariable Integer userId) {
        return debitService.findByUserId(userId);
    }

    @GetMapping("/debits")
    public List<Debit> findAll() {
        return debitService.findAllDebits();
    }

    @PostMapping("/users/{userId}/debits")
    public Debit save(@PathVariable Integer userId, @RequestBody Debit debit) {
        return debitService.save(userId, debit);
    }


    @PutMapping("/debits/{debitId}")
    public Debit update(@PathVariable Integer debitId, @RequestBody Debit debit) {
        return debitService.update(debitId, debit);
    }

    @PutMapping("/users/{userId}/debits/{debitId}")
    public Debit updateUserDebit(@PathVariable Integer userId, @PathVariable Integer debitId, @RequestBody Debit debit) {
        return debitService.updateUserDebit(userId, debitId, debit);
    }

    @DeleteMapping("/debits/{debitId}")
    public void delete(@PathVariable Integer debitId) {
        debitService.delete(debitId);
    }

    @DeleteMapping("/users/{userId}/debits/{debitId}")
    public String deleteUserDebit(@PathVariable Integer userId, @PathVariable Integer debitId) {
        return debitService.deleteUserDebit(userId, debitId);
    }
}

