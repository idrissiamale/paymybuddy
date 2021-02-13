package com.openclassrooms.paymybuddy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ContactTransactionId implements Serializable {
    @Column(name = "transaction_id")
    private Integer transactionId;

    @Column(name = "contact_id")
    private Integer contactId;
}
