package com.example.wealthmanagement.Msg;

import com.example.wealthmanagement.WealthDto.StockDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockMsg {
private StockDto response;
private String message;
}
