package com.openclassrooms.paymybuddy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
}
