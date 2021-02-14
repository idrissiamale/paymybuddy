package com.openclassrooms.paymybuddy.repository;

import com.openclassrooms.paymybuddy.TransactionType;
import com.openclassrooms.paymybuddy.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    Transaction findByTransactionType(TransactionType transactionType);
}
