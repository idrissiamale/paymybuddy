package com.openclassrooms.paymybuddy.repository;

import com.openclassrooms.paymybuddy.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface TransactionBaseRepository<T extends Transaction> extends JpaRepository<T, Integer> {
    List<T> findByUserId(Integer userId);

    List<T> findAll();

    T save(Integer userId, T t);

    T update(Integer userId, Integer id, T t);

    void delete(T t);
}

