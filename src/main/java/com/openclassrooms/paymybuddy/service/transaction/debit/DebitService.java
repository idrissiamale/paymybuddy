package com.openclassrooms.paymybuddy.service.transaction.debit;

import com.openclassrooms.paymybuddy.model.Debit;

import java.util.List;

public interface DebitService {
    Debit findById(Integer id);

    List<Debit> findByUserId(Integer userId);

    List<Debit> findAllDebits();

    Debit save(Integer userId, Debit debit);

    Debit update(Integer debitId, Debit debit);

    Debit updateUserDebit(Integer userId, Integer debitId, Debit debit);

    void delete(Integer debitId);

    String deleteUserDebit(Integer userId, Integer debitId);
}

