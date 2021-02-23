package com.openclassrooms.paymybuddy.service.transaction.payment;

import com.openclassrooms.paymybuddy.model.Payment;

import java.util.List;

public interface PaymentService {
    List<Payment> findByUserId(Integer userId);

    List<Payment> findAllPayments();

    Payment save(Integer userId, Payment payment);

    Payment update(Integer userId, Integer id, Payment payment);

    void delete(Payment payment);
}
