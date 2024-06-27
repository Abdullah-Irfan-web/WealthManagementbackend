package com.example.wealthmanagement.Msg;

import com.example.wealthmanagement.WealthDto.UserDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserMsg {
    
    private UserDto response;
    private String message;
}
