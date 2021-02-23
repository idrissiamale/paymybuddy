package com.openclassrooms.paymybuddy.repository;

import com.openclassrooms.paymybuddy.model.Debit;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface DebitRepository extends TransactionBaseRepository<Debit> {
    @Query("from Debit")
    List<Debit> findAllDebits();
}
