package com.openclassrooms.paymybuddy.service.transaction;

import com.openclassrooms.paymybuddy.exception.ResourceNotFoundException;
import com.openclassrooms.paymybuddy.model.Transaction;
import com.openclassrooms.paymybuddy.repository.TransactionRepository;
import com.openclassrooms.paymybuddy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Transaction findById(Integer id) {
        return transactionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Contact not found with id " + id));
    }

    @Override
    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    @Override
    public String deleteById(Integer userId, Integer transactionId) {
        if (!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException("User not found with id: " + userId);
        }
        return transactionRepository.findById(transactionId)
                .map(transactionToDelete -> {
                    transactionRepository.delete(transactionToDelete);
                    return "Delete Successfully";
                }).orElseThrow(() -> new ResourceNotFoundException("Transaction not found !"));
    }
}
