package com.openclassrooms.paymybuddy.repository;

import com.openclassrooms.paymybuddy.model.Debit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DebitRepository extends JpaRepository<Debit, Integer> {
}
