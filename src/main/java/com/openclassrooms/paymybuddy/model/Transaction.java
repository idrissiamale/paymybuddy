package com.openclassrooms.paymybuddy.model;

import com.openclassrooms.paymybuddy.TransactionType;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date", nullable = false)
    private Date transactionDate;
    private double amount;
    @Column(name = "transaction_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "contact_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Contact contact;


    public Transaction(Date transactionDate, double amount, TransactionType transactionType, String description) {
        this.transactionDate = transactionDate;
        this.amount = amount;
        this.transactionType = transactionType;
        this.description = description;
    }
}
