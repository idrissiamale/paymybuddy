package com.openclassrooms.paymybuddy.service.bankAccount;

import com.openclassrooms.paymybuddy.model.BankAccount;

import java.util.List;

public interface BankAccountService {
    List<BankAccount> findAll();

    List<BankAccount> findByAccountId(Integer accountId);

    BankAccount findByIban(String iban);

    BankAccount save(Integer accountId, BankAccount bankAccount);

    BankAccount update(Integer accountId, Integer bankAccountId, BankAccount bankAccount);

    String delete(Integer accountId, Integer bankAccountId);
}
