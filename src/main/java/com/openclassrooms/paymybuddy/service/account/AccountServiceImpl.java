package com.openclassrooms.paymybuddy.service.account;

import com.openclassrooms.paymybuddy.exception.ResourceNotFoundException;
import com.openclassrooms.paymybuddy.model.Account;
import com.openclassrooms.paymybuddy.repository.AccountRepository;
import com.openclassrooms.paymybuddy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account findById(Integer id) {
        return accountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Account not found with id " + id));
    }

    @Override
    public List<Account> findByUserId(Integer userId) {
        if (!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException("User not found with id: " + userId);
        }
        return accountRepository.findByUserId(userId);
    }

    @Override
    public Account save(Integer userId, Account account) {
        return userRepository.findById(userId).map(user -> {
            account.setUser(user);
            return accountRepository.save(account);
        }).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
    }

    @Override
    public Account update(Integer accountId, Account account) {
        return accountRepository.findById(accountId)
                .map(accountToUpdate -> {
                    accountToUpdate.setBalance(account.getBalance());
                    return accountRepository.save(accountToUpdate);
                }).orElseThrow(() -> new ResourceNotFoundException("Account not found!"));
    }

    @Override
    public String delete(Integer accountId) {
        return accountRepository.findById(accountId)
                .map(account -> {
                    accountRepository.delete(account);
                    return "Deleted Successfully!";
                }).orElseThrow(() -> new ResourceNotFoundException("Account not found!"));
    }
}
