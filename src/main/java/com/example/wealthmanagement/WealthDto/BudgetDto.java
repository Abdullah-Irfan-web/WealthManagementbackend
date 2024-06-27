package com.example.wealthmanagement.WealthDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BudgetDto {
    private int id;
    private String name;
    private int amount;
    private String email;
}
