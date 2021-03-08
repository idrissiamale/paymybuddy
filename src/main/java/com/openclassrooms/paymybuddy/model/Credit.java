package com.openclassrooms.paymybuddy.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue(value = "CREDIT")
public class Credit extends Transaction {

    public Credit() {
    }

    public Credit(LocalDateTime transactionDate, double amount) {
        super(transactionDate, amount);
    }
}
