package com.openclassrooms.paymybuddy.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "user")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String address;
    private String city;
    @Column(unique = true)
    private String email;
    private String password;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "user")
    @JsonIgnoreProperties("user")
    private Account account;

    public User(String name, String address, String city, String email, String password) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.email = email;
        this.password = password;
    }
}
