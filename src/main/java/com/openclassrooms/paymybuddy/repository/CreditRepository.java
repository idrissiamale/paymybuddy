package com.openclassrooms.paymybuddy.repository;

import com.openclassrooms.paymybuddy.model.Credit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditRepository extends JpaRepository<Credit, Integer> {
}
