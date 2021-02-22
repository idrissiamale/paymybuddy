package com.openclassrooms.paymybuddy.service.user;

import com.openclassrooms.paymybuddy.exception.BadArgumentException;
import com.openclassrooms.paymybuddy.exception.ResourceNotFoundException;
import com.openclassrooms.paymybuddy.model.User;
import com.openclassrooms.paymybuddy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public User save(User user) {
        if (user.getId() != null) {
            throw new BadArgumentException("User with id " + user.getId() + " already exists in our database.");
        } else {
            return userRepository.save(user);
        }
    }

    @Override
    public List<User> saveAll(List<User> users) {
        return userRepository.saveAll(users);
    }

    @Override
    public User update(Integer id, User user) {
        return userRepository.findById(id).map(userToUpdate -> {
            userToUpdate.setName(user.getName());
            userToUpdate.setEmail(user.getEmail());
            userToUpdate.setPassword(user.getPassword());
            return userRepository.save(userToUpdate);
        }).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    }


    @Override
    public String deleteById(Integer id) {
        return userRepository.findById(id).map(userToDelete -> {
            userRepository.deleteById(id);
            return "Delete Successfully";
        }).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    }
}
