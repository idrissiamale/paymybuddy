package com.openclassrooms.paymybuddy.controller;

import com.openclassrooms.paymybuddy.model.Contact;
import com.openclassrooms.paymybuddy.service.contact.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactController {
    @Autowired
    private ContactService contactService;

    @PostMapping("/users/{userId}/contacts")
    public Contact saveContact(@PathVariable Integer userId, @RequestBody Contact contact) {
        return contactService.save(userId, contact);
    }

    @GetMapping("/users/{userId}/contacts")
    public List<Contact> findContactByUserId(@PathVariable Integer userId) {
        return contactService.findByUserId(userId);
    }
}
