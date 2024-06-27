
package com.example.wealthmanagement.WealthEntities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Transactions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionEntity{

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String date;
    private String day;
    private String type;
    private String description;
    private float amount;
    private String balance;
    private String paymentMethod;
    private String email;

}