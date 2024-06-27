package com.example.wealthmanagement.WealthDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssetDto {
   

    private int id;
    private String email;
    private String name;
    private float value;
    
}
