package com.openclassrooms.paymybuddy.service.transaction.payment;

import com.openclassrooms.paymybuddy.exception.ResourceNotFoundException;
import com.openclassrooms.paymybuddy.model.Contact;
import com.openclassrooms.paymybuddy.model.Payment;
import com.openclassrooms.paymybuddy.model.User;
import com.openclassrooms.paymybuddy.repository.ContactRepository;
import com.openclassrooms.paymybuddy.repository.PaymentRepository;
import com.openclassrooms.paymybuddy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ContactRepository contactRepository;

    @Override
    public Payment findById(Integer id) {
        return paymentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
    }

    @Override
    public List<Payment> findByUserId(Integer userId) {
        if (!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException("User not found!");
        }
        return paymentRepository.findByUserId(userId);
    }


    @Override
    public List<Payment> findAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment save(Integer userId, Integer contactId, Payment payment) {
        User user = findUserById(userId);
        Contact contact = findContactById(contactId);
        payment.setUser(user);
        payment.setContact(contact);
        return paymentRepository.save(payment);
    }


    @Override
    public Payment update(Integer paymentId, Payment payment) {
        return paymentRepository.findById(paymentId)
                .map(paymentToUpdate -> {
                    paymentToUpdate.setAmount(payment.getAmount());
                    paymentToUpdate.setDescription(payment.getDescription());
                    return paymentRepository.save(paymentToUpdate);
                }).orElseThrow(() -> new ResourceNotFoundException("Payment not found with id: " + paymentId));
    }

    @Override
    public Payment updateUserPayment(Integer userId, Integer paymentId, Payment payment) {
        if (!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException("User not found!");
        }

        return paymentRepository.findById(paymentId)
                .map(paymentToUpdate -> {
                    paymentToUpdate.setAmount(payment.getAmount());
                    paymentToUpdate.setDescription(payment.getDescription());
                    return paymentRepository.save(paymentToUpdate);
                }).orElseThrow(() -> new ResourceNotFoundException("Payment not found!"));
    }

    @Override
    public void delete(Integer paymentId) {
        paymentRepository.deleteById(paymentId);
    }

    @Override
    public String deleteUserPayment(Integer userId, Integer paymentId) {
        if (!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException("User not found!");
        }

        return paymentRepository.findById(paymentId)
                .map(payment -> {
                    paymentRepository.delete(payment);
                    return "Deleted Successfully!";
                }).orElseThrow(() -> new ResourceNotFoundException("Contact not found!"));
    }

    private Contact findContactById(Integer contactId) {
        return contactRepository.findById(contactId).orElseThrow(() -> new ResourceNotFoundException("Contact not found with id " + contactId));
    }

    private User findUserById(Integer userId) {
        return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + userId));
    }
}

