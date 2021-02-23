package com.openclassrooms.paymybuddy.service.transaction.credit;

import com.openclassrooms.paymybuddy.model.Credit;

import java.util.List;

public interface CreditService {
    List<Credit> findByUserId(Integer userId);

    List<Credit> findAllCredits();

    Credit save(Integer userId, Credit credit);

    Credit update(Integer userId, Integer id, Credit credit);

    void delete(Credit credit);
}
