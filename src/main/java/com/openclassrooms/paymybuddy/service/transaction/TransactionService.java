package com.openclassrooms.paymybuddy.service.transaction;

import com.openclassrooms.paymybuddy.model.Transaction;

import java.util.List;

public interface TransactionService {
    Transaction findById(Integer id);

    List<Transaction> findAll();

    String deleteById(Integer userId, Integer transactionId);
}
