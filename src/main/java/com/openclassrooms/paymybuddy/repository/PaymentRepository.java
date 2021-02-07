package com.openclassrooms.paymybuddy.repository;

import com.openclassrooms.paymybuddy.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
