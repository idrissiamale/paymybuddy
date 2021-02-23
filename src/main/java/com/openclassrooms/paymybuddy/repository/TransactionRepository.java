package com.openclassrooms.paymybuddy.repository;

import com.openclassrooms.paymybuddy.model.Transaction;

import javax.transaction.Transactional;

@Transactional
public interface TransactionRepository extends TransactionBaseRepository<Transaction> {
}
