package com.openclassrooms.paymybuddy.repository;

import com.openclassrooms.paymybuddy.TransactionType;
import com.openclassrooms.paymybuddy.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    Transaction findByTransactionType(TransactionType transactionType);

    List<Transaction> findByUserId(Integer userId);
}
