package com.example.wealthmanagement.Msg;

import com.example.wealthmanagement.WealthDto.AssetDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssetMsg {
    
    private AssetDto response;
    private String message;
}
