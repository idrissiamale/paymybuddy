package com.openclassrooms.paymybuddy.service.transaction;

import com.openclassrooms.paymybuddy.TransactionType;
import com.openclassrooms.paymybuddy.model.Transaction;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Override
    public Transaction findByTransactionType(TransactionType transactionType) {
        return null;
    }
}
