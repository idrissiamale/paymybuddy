package com.openclassrooms.paymybuddy.service.transaction.debit;

import com.openclassrooms.paymybuddy.exception.ResourceNotFoundException;
import com.openclassrooms.paymybuddy.model.Debit;
import com.openclassrooms.paymybuddy.repository.DebitRepository;
import com.openclassrooms.paymybuddy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DebitServiceImpl implements DebitService {
    @Autowired
    private DebitRepository debitRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Debit findById(Integer id) {
        return debitRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Debit not found with id " + id));
    }

    @Override
    public List<Debit> findByUserId(Integer userId) {
        if (!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException("User not found!");
        }
        return debitRepository.findByUserId(userId);
    }

    @Override
    public List<Debit> findAllDebits() {
        return debitRepository.findAll();
    }

    @Override
    public Debit save(Integer userId, Debit debit) {
        return userRepository.findById(userId).map(user -> {
            debit.setUser(user);
            return debitRepository.save(debit);
        }).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
    }

    @Override
    public Debit update(Integer debitId, Debit debit) {
        return debitRepository.findById(debitId)
                .map(debitToUpdate -> {
                    debitToUpdate.setAmount(debit.getAmount());
                    return debitRepository.save(debitToUpdate);
                }).orElseThrow(() -> new ResourceNotFoundException("Debit not found with id: " + debitId));
    }

    @Override
    public Debit updateUserDebit(Integer userId, Integer debitId, Debit debit) {
        if (!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException("User not found with id: " + userId);
        }
        return debitRepository.findById(debitId)
                .map(debitToUpdate -> {
                    debitToUpdate.setAmount(debit.getAmount());
                    return debitRepository.save(debitToUpdate);
                }).orElseThrow(() -> new ResourceNotFoundException("Debit not found with id: " + debitId));
    }

    @Override
    public void delete(Integer debitId) {
        debitRepository.deleteById(debitId);
    }

    @Override
    public String deleteUserDebit(Integer userId, Integer debitId) {
        if (!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException("User not found!");
        }
        return debitRepository.findById(debitId)
                .map(debit -> {
                    debitRepository.delete(debit);
                    return "Deleted Successfully!";
                }).orElseThrow(() -> new ResourceNotFoundException("Debit not found!"));
    }
}

