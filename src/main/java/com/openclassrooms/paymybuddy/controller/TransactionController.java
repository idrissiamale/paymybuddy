package com.openclassrooms.paymybuddy.controller;

import com.openclassrooms.paymybuddy.model.Transaction;
import com.openclassrooms.paymybuddy.service.transaction.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping("/users/{userId}/transactions")
    public ResponseEntity<Transaction> saveTransaction(@PathVariable Integer userId, @RequestBody Transaction transaction) {
        transactionService.save(userId, transaction);
        return new ResponseEntity<>(transaction, HttpStatus.CREATED);
    }
}

