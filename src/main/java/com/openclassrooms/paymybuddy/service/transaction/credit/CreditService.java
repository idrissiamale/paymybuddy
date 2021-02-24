package com.openclassrooms.paymybuddy.service.transaction.credit;

import com.openclassrooms.paymybuddy.model.Credit;

import java.util.List;

public interface CreditService {
    Credit findById(Integer id);

    List<Credit> findByUserId(Integer userId);

    List<Credit> findAllCredits();

    Credit save(Integer userId, Credit credit);

    Credit update(Integer creditId, Credit credit);

    Credit updateUserCredit(Integer userId, Integer creditId, Credit credit);

    void delete(Integer creditId);

    String deleteUserCredit(Integer userId, Integer creditId);
}
