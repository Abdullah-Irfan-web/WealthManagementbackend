package com.example.wealthmanagement.WealthDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDto {

    private int id;
    private String name;
    private String emailfrom;
    private String emailto;
    private float amount;
    private String date;
private String day;
private String time;


}
