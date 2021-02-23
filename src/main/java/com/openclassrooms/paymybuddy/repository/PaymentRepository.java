package com.openclassrooms.paymybuddy.repository;

import com.openclassrooms.paymybuddy.model.Payment;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface PaymentRepository extends TransactionBaseRepository<Payment> {
    @Query("from Payment")
    List<Payment> findAllPayments();
}
