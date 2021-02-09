package com.openclassrooms.paymybuddy.repository;

import com.openclassrooms.paymybuddy.model.ContactUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactUserRepository extends JpaRepository<ContactUser, Integer> {
}
