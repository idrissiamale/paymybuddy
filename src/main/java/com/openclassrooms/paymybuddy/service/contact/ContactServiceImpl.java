package com.openclassrooms.paymybuddy.service.contact;

import com.openclassrooms.paymybuddy.exception.ResourceNotFoundException;
import com.openclassrooms.paymybuddy.model.Contact;
import com.openclassrooms.paymybuddy.repository.ContactRepository;
import com.openclassrooms.paymybuddy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    @Override
    public Contact findById(Integer id) {
        return contactRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found with id " + id));
    }

    @Override
    public List<Contact> findByUserId(Integer userId) {
        if (!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException("User not found with id: " + userId);
        }
        return contactRepository.findByUserId(userId);
    }

    @Override
    public Contact findByEmail(String email) {
        return contactRepository.findByEmail(email);
    }

    @Override
    public Contact save(Integer userId, Contact contact) {
        return userRepository.findById(userId).map(user -> {
            contact.setUser(user);
            return contactRepository.save(contact);
        }).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
    }

    @Override
    public Contact update(Integer userId, Integer contactId, Contact contact) {
        if (!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException("User not found with id: " + userId);
        }
        return contactRepository.findById(contactId)
                .map(contactToUpdate -> {
                    contactToUpdate.setName(contact.getName());
                    contactToUpdate.setEmail(contact.getEmail());
                    return contactRepository.save(contactToUpdate);
                }).orElseThrow(() -> new ResourceNotFoundException("Contact not found with id: " + contactId));
    }

    @Override
    public String delete(Integer userId, Integer contactId) {
        if (!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException("User not found with id: " + userId);
        }
        return contactRepository.findById(contactId)
                .map(contactToDelete -> {
                    contactRepository.delete(contactToDelete);
                    return "Delete Successfully";
                }).orElseThrow(() -> new ResourceNotFoundException("Contact not found !"));
    }
}
