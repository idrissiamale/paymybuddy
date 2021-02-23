package com.openclassrooms.paymybuddy.service.transaction.credit;

import com.openclassrooms.paymybuddy.exception.ResourceNotFoundException;
import com.openclassrooms.paymybuddy.model.Credit;
import com.openclassrooms.paymybuddy.repository.CreditRepository;
import com.openclassrooms.paymybuddy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CreditServiceImpl implements CreditService {
    @Autowired
    private CreditRepository creditRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Credit> findByUserId(Integer userId) {
        return creditRepository.findByUserId(userId);
    }

    @Override
    public List<Credit> findAllCredits() {
        return creditRepository.findAllCredits();
    }

    @Override
    public Credit save(Integer userId, Credit credit) {
        return userRepository.findById(userId).map(user -> {
            credit.setUser(user);
            return creditRepository.save(credit);
        }).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
    }

    @Override
    public Credit update(Integer userId, Integer creditId, Credit credit) {
        if (!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException("User not found with id: " + userId);
        }
        return creditRepository.findById(creditId)
                .map(creditToUpdate -> {
                    creditToUpdate.setTransactionDate(credit.getTransactionDate());
                    creditToUpdate.setAmount(credit.getAmount());
                    return creditRepository.save(creditToUpdate);
                }).orElseThrow(() -> new ResourceNotFoundException("Credit not found with id: " + creditId));
    }

    @Override
    public void delete(Credit credit) {
        creditRepository.delete(credit);
    }
}
