package com.openclassrooms.paymybuddy.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "contact_transaction")
public class ContactTransaction {
    @EmbeddedId
    private ContactTransactionId id;

    @ManyToOne
    @MapsId("contactId")
    @JoinColumn(name = "contact_id")
    private Contact contact;

    @ManyToOne
    @MapsId("transactionId")
    @JoinColumn(name = "transaction_id")
    private Transaction transaction;

    @Column(name = "contact_name")
    private String contactName;

    private String description;

    public ContactTransaction(Contact contact, Transaction transaction, String contactName, String description) {
        this.id = new ContactTransactionId(contact.getId(), transaction.getId());
        this.contact = contact;
        this.transaction = transaction;
        this.contactName = contactName;
        this.description = description;
    }
}
