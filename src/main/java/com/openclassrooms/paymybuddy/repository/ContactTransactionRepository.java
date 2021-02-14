package com.openclassrooms.paymybuddy.repository;

import com.openclassrooms.paymybuddy.model.ContactTransaction;
import com.openclassrooms.paymybuddy.model.ContactTransactionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactTransactionRepository extends JpaRepository<ContactTransaction, ContactTransactionId> {
}
