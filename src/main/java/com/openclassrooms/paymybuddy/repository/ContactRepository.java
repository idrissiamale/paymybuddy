package com.openclassrooms.paymybuddy.repository;

import com.openclassrooms.paymybuddy.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
    Contact findByEmail(String email);

    List<Contact> findByUserId(int userId);
}
