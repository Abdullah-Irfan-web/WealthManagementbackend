package com.example.wealthmanagement.WealthDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDto {

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
