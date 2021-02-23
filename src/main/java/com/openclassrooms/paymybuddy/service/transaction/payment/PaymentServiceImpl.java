package com.openclassrooms.paymybuddy.service.transaction.payment;

import com.openclassrooms.paymybuddy.exception.ResourceNotFoundException;
import com.openclassrooms.paymybuddy.model.Payment;
import com.openclassrooms.paymybuddy.repository.PaymentRepository;
import com.openclassrooms.paymybuddy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Payment> findByUserId(Integer userId) {
        return paymentRepository.findByUserId(userId);
    }

    @Override
    public List<Payment> findAllPayments() {
        return paymentRepository.findAllPayments();
    }

    @Override
    public Payment save(Integer userId, Payment payment) {
        return userRepository.findById(userId).map(user -> {
            payment.setUser(user);
            return paymentRepository.save(payment);
        }).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
    }

    @Override
    public Payment update(Integer userId, Integer paymentId, Payment payment) {
        if (!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException("User not found with id: " + userId);
        }
        return paymentRepository.findById(paymentId)
                .map(paymentToUpdate -> {
                    paymentToUpdate.setTransactionDate(payment.getTransactionDate());
                    paymentToUpdate.setAmount(payment.getAmount());
                    paymentToUpdate.setDescription(payment.getDescription());
                    return paymentRepository.save(paymentToUpdate);
                }).orElseThrow(() -> new ResourceNotFoundException("Payment not found with id: " + paymentId));
    }

    @Override
    public void delete(Payment payment) {
        paymentRepository.delete(payment);
    }
}
