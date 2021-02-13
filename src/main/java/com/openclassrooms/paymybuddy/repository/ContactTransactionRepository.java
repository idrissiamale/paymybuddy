package com.openclassrooms.paymybuddy.repository;

import com.openclassrooms.paymybuddy.model.ContactTransaction;
import com.openclassrooms.paymybuddy.model.ContactTransactionId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactTransactionRepository extends JpaRepository<ContactTransaction, ContactTransactionId> {
}
