package com.openclassrooms.paymybuddy.repository;

import com.openclassrooms.paymybuddy.model.Credit;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface CreditRepository extends TransactionBaseRepository<Credit> {
    @Query("from Credit")
    List<Credit> findAllCredits();
}

