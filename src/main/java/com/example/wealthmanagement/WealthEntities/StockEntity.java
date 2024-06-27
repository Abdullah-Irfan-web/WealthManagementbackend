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
@Table(name="Stock")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String symbol;
    private float price;
    private int quantity;
    private String email;
}
