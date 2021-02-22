package com.openclassrooms.paymybuddy.controller;

import com.openclassrooms.paymybuddy.model.BankAccount;
import com.openclassrooms.paymybuddy.service.bankAccount.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BankAccountController {
    @Autowired
    private BankAccountService bankAccountService;

    @PostMapping("/accounts/{accountId}/bankaccounts")
    public BankAccount saveBankAccount(@PathVariable Integer accountId, @RequestBody BankAccount bankAccount) {
        return bankAccountService.save(accountId, bankAccount);
    }

    @GetMapping("/accounts/{accountId}/bankaccounts")
    public List<BankAccount> findBankAccountByAccountId(@PathVariable Integer accountId) {
        return bankAccountService.findByAccountId(accountId);
    }
}
