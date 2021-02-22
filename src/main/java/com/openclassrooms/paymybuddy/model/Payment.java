package com.openclassrooms.paymybuddy.model;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@DiscriminatorValue(value = "PAYMENT")
public class Payment extends Transaction {
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Contact contact;

    public Payment() {
    }

    public Payment(LocalDateTime transactionDate, double amount, String description) {
        super(transactionDate, amount);
        this.description = description;
    }
}
