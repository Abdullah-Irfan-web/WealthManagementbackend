package com.example.wealthmanagement.Msg;

import com.example.wealthmanagement.WealthDto.PaymentDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentMsg {


    private PaymentDto response;
    private String message;

}
