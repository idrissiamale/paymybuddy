package com.openclassrooms.paymybuddy.service.transaction.payment;

import com.openclassrooms.paymybuddy.model.Payment;

import java.util.List;

public interface PaymentService {
    Payment findById(Integer id);

    List<Payment> findByUserId(Integer userId);

    List<Payment> findAllPayments();

    Payment save(Integer userId, Integer contactId, Payment payment);

    Payment update(Integer paymentId, Payment payment);

    Payment updateUserPayment(Integer userId, Integer paymentId, Payment payment);

    void delete(Integer paymentId);

    String deleteUserPayment(Integer userId, Integer paymentId);
}
