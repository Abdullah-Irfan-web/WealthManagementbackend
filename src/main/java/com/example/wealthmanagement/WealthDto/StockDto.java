package com.example.wealthmanagement.WealthDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockDto {

    private int id;
    private String symbol;
    private float price;
    private int quantity;
    private String email;

}
