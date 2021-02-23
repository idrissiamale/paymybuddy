package com.openclassrooms.paymybuddy.service.transaction.debit;

import com.openclassrooms.paymybuddy.model.Debit;

import java.util.List;

public interface DebitService {
    List<Debit> findByUserId(Integer userId);

    List<Debit> findAllDebits();

    Debit save(Integer userId, Debit debit);

    Debit update(Integer userId, Integer id, Debit debit);

    void delete(Debit debit);
}
