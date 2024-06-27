package com.example.wealthmanagement.Msg;

import com.example.wealthmanagement.WealthDto.TransactionDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionMsg {

        private TransactionDto response;
        private String Message;
}
