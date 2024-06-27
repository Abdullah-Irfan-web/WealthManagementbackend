package com.example.wealthmanagement.WealthController;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.wealthmanagement.Msg.AssetMsg;
import com.example.wealthmanagement.Msg.BudgetMsg;
import com.example.wealthmanagement.Msg.LiabilityMsg;
import com.example.wealthmanagement.Msg.StockMsg;
import com.example.wealthmanagement.Msg.TransactionMsg;
import com.example.wealthmanagement.Msg.UserMsg;
import com.example.wealthmanagement.WealthDto.AssetDto;
import com.example.wealthmanagement.WealthDto.BudgetDto;
import com.example.wealthmanagement.WealthDto.LiabilityDto;
import com.example.wealthmanagement.WealthDto.StockDto;
import com.example.wealthmanagement.WealthDto.TransactionDto;
import com.example.wealthmanagement.WealthDto.UserDto;
import com.example.wealthmanagement.WealthService.Assetservice;
import com.example.wealthmanagement.WealthService.BudgetService;
import com.example.wealthmanagement.WealthService.Liabilityservice;
import com.example.wealthmanagement.WealthService.Stockservice;
import com.example.wealthmanagement.WealthService.Transactionservice;
import com.example.wealthmanagement.WealthService.Userservice;

import yahoofinance.YahooFinance;










@RestController
@CrossOrigin
public class Controllers {
    
    final Userservice userservice;
    final Assetservice assetservice;
    final Liabilityservice liabilityservice;
    final Transactionservice transactionservice;
    final BudgetService budgetservice;
    final Stockservice stockservice;
    

public Controllers(Userservice userservice, Assetservice assetservice, Liabilityservice liabilityservice,
            Transactionservice transactionservice, BudgetService budgetservice,Stockservice stockservice ) {
        this.userservice = userservice;
        this.assetservice = assetservice;
        this.liabilityservice = liabilityservice;
        this.transactionservice = transactionservice;
        this.budgetservice=budgetservice;
        this.stockservice=stockservice;
    }




// User Mapping
@PostMapping("/register")
public UserMsg create(@RequestBody UserDto userDto) {

    return userservice.createUser(userDto);
}

@PostMapping("/login")
public UserMsg login(@RequestBody UserDto userDto) {
     
    return userservice.login(userDto);
}

// Asset Mapping
@GetMapping("/getasset/{email}")
public List<AssetDto> getasset(@PathVariable String email) {
    return assetservice.getasset(email);
}


@PostMapping("/addassest")
public AssetMsg addasset(@RequestBody AssetDto assetDto) {
   
    System.out.println(assetDto);
    return assetservice.addasset(assetDto);
}

@PutMapping("/updateasset")
public AssetMsg updateasset( @RequestBody AssetDto assetDto) {
  
    
    return assetservice.updateasset(assetDto);
}

@GetMapping("/deleteasset/{id}")
public AssetMsg deleteasset(@PathVariable int id) {
    return assetservice.deleteasset(id);
}



// Liability Mapping
@PostMapping("/addliability")
public LiabilityMsg addliability(@RequestBody LiabilityDto liabilityDto ) {
    
    return liabilityservice.addliability(liabilityDto);
}

@GetMapping("/getliability/{email}")
public List<LiabilityDto> getliability(@PathVariable String email) {
    return liabilityservice.getliability(email);
}
@PutMapping("/updateliability")
public LiabilityMsg updateliability( @RequestBody LiabilityDto liabilityDto) {
  
    
    return liabilityservice.updateliability(liabilityDto);
}

@GetMapping("/deleteliability/{id}")
public LiabilityMsg deleteliability(@PathVariable int id) {
    return liabilityservice.deleteliability(id);
}


// Transaction Mapping

@GetMapping("/gettransaction/{email}")
public List<TransactionDto> gettransaction(@PathVariable String email) {
    return transactionservice.gettransaction(email);
}

@PostMapping("/addtransaction")
public TransactionMsg addtransaction(@RequestBody TransactionDto transactionDto) {
    
   String type= transactionDto.getType();
    String email=transactionDto.getEmail();
    int amount=(int)transactionDto.getAmount();
    String balance=transactionDto.getBalance();

   System.out.println( budgetservice.update(type,email,amount,balance));

    return transactionservice.addtransaction(transactionDto);
}


// Budget Mapping


@PostMapping("/addbudget")
public BudgetMsg addbudget(@RequestBody BudgetDto budgetDto) {

    
    return budgetservice.addbudget(budgetDto);
}

@PutMapping("/updatebudget")
public BudgetMsg putMethodName( @RequestBody BudgetDto budgetDto) {
return budgetservice.updatebudget(budgetDto);
}

@GetMapping("/getbudget/{email}")
public List<BudgetDto> getbudget(@PathVariable String email) {

    return budgetservice.getbudget(email);
}


@GetMapping("/getstock/{email}")
public List<StockDto> getstock(@PathVariable String email) {

    return stockservice.getstock(email);
}
@GetMapping("/sellstock/{id}")
public StockMsg sellstock(@PathVariable int id) {
    return stockservice.sellstock(id);
}


@PostMapping("/addstock")
public StockMsg addstock(@RequestBody StockDto stockDto) {
   
    
    return stockservice.addstock(stockDto);
}













}
