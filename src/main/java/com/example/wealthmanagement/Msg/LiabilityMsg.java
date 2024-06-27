package com.example.wealthmanagement.Msg;

import com.example.wealthmanagement.WealthDto.LiabilityDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LiabilityMsg {
 private LiabilityDto response;
    private String message;
}
