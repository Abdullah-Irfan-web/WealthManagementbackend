package com.example.wealthmanagement.Msg;

import com.example.wealthmanagement.WealthDto.BudgetDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BudgetMsg {
    private BudgetDto response;
    private String message;
}
