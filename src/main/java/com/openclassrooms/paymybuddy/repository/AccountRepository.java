package com.openclassrooms.paymybuddy.repository;

import com.openclassrooms.paymybuddy.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
}
