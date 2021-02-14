package com.openclassrooms.paymybuddy.service.transaction;

import com.openclassrooms.paymybuddy.TransactionType;
import com.openclassrooms.paymybuddy.model.Transaction;

public interface TransactionService {
    Transaction findByTransactionType(TransactionType transactionType);
}
