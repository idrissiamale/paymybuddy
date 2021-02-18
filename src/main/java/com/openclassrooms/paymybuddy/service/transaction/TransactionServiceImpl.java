package com.openclassrooms.paymybuddy.service.transaction;

import com.openclassrooms.paymybuddy.TransactionType;
import com.openclassrooms.paymybuddy.exception.ResourceNotFoundException;
import com.openclassrooms.paymybuddy.model.Transaction;
import com.openclassrooms.paymybuddy.repository.ContactRepository;
import com.openclassrooms.paymybuddy.repository.TransactionRepository;
import com.openclassrooms.paymybuddy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ContactRepository contactRepository;

    @Override
    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    @Override
    public List<Transaction> findByUserId(Integer userId) {
        if (!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException("User not found with id: " + userId);
        }
        return transactionRepository.findByUserId(userId);
    }

    @Override
    public Transaction findByTransactionType(TransactionType transactionType) {
        return transactionRepository.findByTransactionType(transactionType);
    }

    @Override
    public Transaction save(Integer userId, Transaction transaction) {
        return userRepository.findById(userId).map(user -> {
            transaction.setUser(user);
            return transactionRepository.save(transaction);
        }).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
    }

    @Override
    public Transaction update(Integer userId, Integer transactionId, Transaction transaction) {
        if (!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException("User not found with id: " + userId);
        }
        return transactionRepository.findById(transactionId)
                .map(transactionToUpdate-> {
                    transactionToUpdate.setTransactionDate(transaction.getTransactionDate());
                    transactionToUpdate.setAmount(transaction.getAmount());
                    transactionToUpdate.setTransactionType(transaction.getTransactionType());
                    transactionToUpdate.setDescription(transaction.getDescription());
                    return transactionRepository.save(transactionToUpdate);
                }).orElseThrow(() -> new ResourceNotFoundException("Transaction with id: " + transactionId + "not found"));
    }

    @Override
    public String delete(Integer userId, Integer transactionId) {
        if (!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException("User not found with id: " + userId);
        }
        return transactionRepository.findById(transactionId)
                .map(transactionToDelete -> {
                    transactionRepository.delete(transactionToDelete);
                    return "Delete Successfully";
                }).orElseThrow(() -> new ResourceNotFoundException("Transaction with id: " + transactionId + "not found"));
    }
}
