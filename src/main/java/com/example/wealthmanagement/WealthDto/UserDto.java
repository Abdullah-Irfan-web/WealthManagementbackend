package com.example.wealthmanagement.WealthDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
   
private int id;
private String Username;
private String email;
private String Password;
private String gender;
private String bankName;
private String bankAccountNumber;
private float totalWealth;


}
