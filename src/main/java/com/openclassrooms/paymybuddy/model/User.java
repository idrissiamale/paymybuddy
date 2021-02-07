package com.openclassrooms.paymybuddy.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String address;

    private String city;

    private String email;

    private String password;

    @OneToOne(mappedBy = "user")
    private Account account;

    @OneToMany(targetEntity = ContactUser.class, mappedBy = "user")
    private List<ContactUser> contactUserList = new ArrayList<>();

    @OneToMany(targetEntity = Transaction.class, mappedBy = "user")
    private List<Transaction> transactions = new ArrayList<>();

    public User() {
    }
}
