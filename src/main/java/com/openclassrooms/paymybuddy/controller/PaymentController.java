package com.openclassrooms.paymybuddy.controller;

import com.openclassrooms.paymybuddy.model.Payment;
import com.openclassrooms.paymybuddy.service.transaction.payment.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("payments/{id}")
    public Payment findById(@PathVariable Integer id) {
        return paymentService.findById(id);
    }

    @GetMapping("users/{userId}/payments")
    public List<Payment> findByUserId(@PathVariable Integer userId) {
        return paymentService.findByUserId(userId);
    }

    @GetMapping("/payments")
    public List<Payment> findAll() {
        return paymentService.findAllPayments();
    }

    @PostMapping("/users/{userId}/contacts/{contactId}/payments")
    public Payment save(@PathVariable Integer userId, @PathVariable Integer contactId, @RequestBody Payment payment) {
        return paymentService.save(userId, contactId, payment);
    }


    @PutMapping("/payments/{paymentId}")
    public Payment update(@PathVariable Integer paymentId, @RequestBody Payment payment) {
        return paymentService.update(paymentId, payment);
    }

    @PutMapping("/users/{userId}/payments/{paymentId}")
    public Payment updateUserPayment(@PathVariable Integer userId, @PathVariable Integer paymentId, @RequestBody Payment payment) {
        return paymentService.updateUserPayment(userId, paymentId, payment);
    }

    @DeleteMapping("/payments/{paymentId}")
    public void delete(@PathVariable Integer paymentId) {
        paymentService.delete(paymentId);
    }

    @DeleteMapping("/users/{userId}/payments/{paymentId}")
    public String deleteUserPayment(@PathVariable Integer userId, @PathVariable Integer paymentId) {
        return paymentService.deleteUserPayment(userId, paymentId);
    }
}

