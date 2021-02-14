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

    @Column(name = "contact_name")
    private String contactName;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("contactId")
    @JoinColumn(name = "contact_id", nullable = false)
    private Contact contact;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("transactionId")
    @JoinColumn(name = "transaction_id", nullable = false)
    private Transaction transaction;

    public ContactTransaction(Contact contact, Transaction transaction, String contactName, String description) {
        this.id = new ContactTransactionId(contact.getId(), transaction.getId());
        this.contact = contact;
        this.transaction = transaction;
        this.contactName = contactName;
        this.description = description;
    }
}
