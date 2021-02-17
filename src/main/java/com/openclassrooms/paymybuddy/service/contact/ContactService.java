package com.openclassrooms.paymybuddy.service.contact;

import com.openclassrooms.paymybuddy.model.Contact;

import java.util.List;

public interface ContactService {
    List<Contact> findAll();

    List<Contact> findByUserId(Integer userId);

    Contact findByEmail(String email);

    Contact save(Integer userId, Contact contact);

    Contact update(Integer userId, Integer contactId, Contact contact);

    String delete(Integer userId, Integer contactId);
}
