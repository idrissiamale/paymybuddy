package com.openclassrooms.paymybuddy.service.transaction.credit;

import com.openclassrooms.paymybuddy.exception.ResourceNotFoundException;
import com.openclassrooms.paymybuddy.model.Credit;
import com.openclassrooms.paymybuddy.repository.CreditRepository;
import com.openclassrooms.paymybuddy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditServiceImpl implements CreditService {
    @Autowired
    private CreditRepository creditRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Credit findById(Integer id) {
        return creditRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Credit not found with id " + id));
    }

    @Override
    public List<Credit> findByUserId(Integer userId) {
        if (!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException("User not found!");
        }
        return creditRepository.findByUserId(userId);
    }

    @Override
    public List<Credit> findAllCredits() {
        return creditRepository.findAll();
    }

    @Override
    public Credit save(Integer userId, Credit credit) {
        return userRepository.findById(userId).map(user -> {
            credit.setUser(user);
            return creditRepository.save(credit);
        }).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
    }

    @Override
    public Credit update(Integer creditId, Credit credit) {
        return creditRepository.findById(creditId)
                .map(paymentToUpdate -> {
                    paymentToUpdate.setAmount(credit.getAmount());
                    return creditRepository.save(paymentToUpdate);
                }).orElseThrow(() -> new ResourceNotFoundException("Payment not found with id: " + creditId));
    }

    @Override
    public Credit updateUserCredit(Integer userId, Integer creditId, Credit credit) {
        if (!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException("User not found with id: " + userId);
        }
        return creditRepository.findById(creditId)
                .map(creditToUpdate -> {
                    creditToUpdate.setAmount(credit.getAmount());
                    return creditRepository.save(creditToUpdate);
                }).orElseThrow(() -> new ResourceNotFoundException("Credit not found with id: " + creditId));
    }

    @Override
    public void delete(Integer creditId) {
        creditRepository.deleteById(creditId);
    }

    @Override
    public String deleteUserCredit(Integer userId, Integer creditId) {
        if (!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException("User not found!");
        }
        return creditRepository.findById(creditId)
                .map(credit -> {
                    creditRepository.delete(credit);
                    return "Deleted Successfully!";
                }).orElseThrow(() -> new ResourceNotFoundException("Credit not found!"));
    }
}

