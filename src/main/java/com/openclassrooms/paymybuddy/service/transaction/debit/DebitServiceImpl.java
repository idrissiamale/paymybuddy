package com.openclassrooms.paymybuddy.service.transaction.debit;

import com.openclassrooms.paymybuddy.exception.ResourceNotFoundException;
import com.openclassrooms.paymybuddy.model.Debit;
import com.openclassrooms.paymybuddy.repository.DebitRepository;
import com.openclassrooms.paymybuddy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DebitServiceImpl implements DebitService {
    @Autowired
    private DebitRepository debitRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Debit> findByUserId(Integer userId) {
        return debitRepository.findByUserId(userId);
    }

    @Override
    public List<Debit> findAllDebits() {
        return debitRepository.findAllDebits();
    }

    @Override
    public Debit save(Integer userId, Debit debit) {
        return userRepository.findById(userId).map(user -> {
            debit.setUser(user);
            return debitRepository.save(debit);
        }).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
    }

    @Override
    public Debit update(Integer userId, Integer debitId, Debit debit) {
        if (!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException("User not found with id: " + userId);
        }
        return debitRepository.findById(debitId)
                .map(debitToUpdate -> {
                    debitToUpdate.setTransactionDate(debit.getTransactionDate());
                    debitToUpdate.setAmount(debit.getAmount());
                    return debitRepository.save(debitToUpdate);
                }).orElseThrow(() -> new ResourceNotFoundException("Debit not found with id: " + debitId));
    }

    @Override
    public void delete(Debit debit) {
        debitRepository.delete(debit);
    }
}
