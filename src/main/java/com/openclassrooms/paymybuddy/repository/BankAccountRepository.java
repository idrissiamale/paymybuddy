package com.openclassrooms.paymybuddy.repository;

import com.openclassrooms.paymybuddy.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, Integer> {
}
