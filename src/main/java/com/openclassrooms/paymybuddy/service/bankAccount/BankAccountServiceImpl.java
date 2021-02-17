package com.openclassrooms.paymybuddy.service.bankAccount;

import com.openclassrooms.paymybuddy.exception.ResourceNotFoundException;
import com.openclassrooms.paymybuddy.model.BankAccount;
import com.openclassrooms.paymybuddy.repository.AccountRepository;
import com.openclassrooms.paymybuddy.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankAccountServiceImpl implements BankAccountService {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<BankAccount> findAll() {
        return bankAccountRepository.findAll();
    }

    @Override
    public List<BankAccount> findByAccountId(Integer accountId) {
        if (!accountRepository.existsById(accountId)) {
            throw new ResourceNotFoundException("User not found with id: " + accountId);
        }
        return bankAccountRepository.findByAccountId(accountId);
    }


    @Override
    public BankAccount findByIban(String iban) {
        return bankAccountRepository.findByIban(iban);
    }

    @Override
    public BankAccount save(Integer accountId, BankAccount bankAccount) {
        return accountRepository.findById(accountId).map(account -> {
            bankAccount.setAccount(account);
            return bankAccountRepository.save(bankAccount);
        }).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + accountId));
    }

    @Override
    public BankAccount update(Integer accountId, Integer bankAccountId, BankAccount bankAccount) {
        if (!accountRepository.existsById(accountId)) {
            throw new ResourceNotFoundException("User not found with id: " + accountId);
        }
        return bankAccountRepository.findById(bankAccountId)
                .map(bankAccountToUpdate-> {
                    bankAccountToUpdate.setIban(bankAccount.getIban());
                    bankAccountToUpdate.setName(bankAccount.getName());
                    return bankAccountRepository.save(bankAccountToUpdate);
                }).orElseThrow(() -> new ResourceNotFoundException("Transaction with id: " + bankAccountId + "not found"));
    }

    @Override
    public String delete(Integer accountId, Integer bankAccountId) {
        if (!accountRepository.existsById(accountId)) {
            throw new ResourceNotFoundException("User not found with id: " + accountId);
        }
        return bankAccountRepository.findById(bankAccountId)
                .map(bankAccountToDelete -> {
                    bankAccountRepository.delete(bankAccountToDelete);
                    return "Delete Successfully";
                }).orElseThrow(() -> new ResourceNotFoundException("Transaction with id: " + bankAccountId + "not found"));
    }
}
