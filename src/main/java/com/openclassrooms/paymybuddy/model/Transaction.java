package com.openclassrooms.paymybuddy.model;

import com.openclassrooms.paymybuddy.TransactionType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "transaction")
    private Set<ContactTransaction> contactTransactions = new HashSet<>();

    public Transaction(Date transactionDate, double amount, TransactionType transactionType) {
        this.transactionDate = transactionDate;
        this.amount = amount;
        this.transactionType = transactionType;
    }
}
