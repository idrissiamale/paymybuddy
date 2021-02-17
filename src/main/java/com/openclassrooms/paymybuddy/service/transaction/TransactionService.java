package com.openclassrooms.paymybuddy.service.transaction;

import com.openclassrooms.paymybuddy.TransactionType;
import com.openclassrooms.paymybuddy.model.Transaction;

import java.util.List;

public interface TransactionService {
    List<Transaction> findAll();

    List<Transaction> findByUserId(Integer userId);

    Transaction findByTransactionType(TransactionType transactionType);

    Transaction save(Integer userId, Transaction transaction);

    Transaction update(Integer userId, Integer transactionId, Transaction transaction);

    String delete(Integer userId, Integer transactionId);
}
