package com.openclassrooms.paymybuddy.service.account;

import com.openclassrooms.paymybuddy.model.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAll();

    Account findById(Integer id);

    List<Account> findByUserId(Integer userId);

    Account save(Integer userId, Account account);

    Account update(Integer accountId, Account account);

    String delete(Integer accountId);
}
