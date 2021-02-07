package com.openclassrooms.paymybuddy.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@Entity
@Table(name = "debit")
@PrimaryKeyJoinColumn(name = "id")
public class Debit extends Transaction {
}
