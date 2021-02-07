package com.openclassrooms.paymybuddy.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
@Table(name = "payment")
@PrimaryKeyJoinColumn(name = "id")
public class Payment extends Transaction {
    @Column(name = "contact_user_name", nullable = false)
    private String contactUserName;

    private String description;

    @ManyToOne
    @JoinColumn(name = "contact_user_id", nullable = false)
    private ContactUser contactUser;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Payment() {
        super();
    }
}
