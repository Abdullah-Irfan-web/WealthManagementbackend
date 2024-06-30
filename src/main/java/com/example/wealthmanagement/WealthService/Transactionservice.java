package com.example.wealthmanagement.WealthService;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.wealthmanagement.Msg.TransactionMsg;
import com.example.wealthmanagement.WealthDto.TransactionDto;
import com.example.wealthmanagement.WealthEntities.TransactionEntity;
import com.example.wealthmanagement.WealthEntities.UserEntity;
import com.example.wealthmanagement.WealthRepo.Transactionrepositories;
import com.example.wealthmanagement.WealthRepo.Userrepositories;

@Service
public class Transactionservice {
        final Transactionrepositories transactionrepo;
        final ModelMapper modelMapper;
        final Userrepositories userrepo;
        public Transactionservice(Transactionrepositories transactionrepo, ModelMapper modelMapper,Userrepositories userrepo) {
            this.transactionrepo = transactionrepo;
            this.modelMapper = modelMapper;
            this.userrepo=userrepo;
        }


        public TransactionMsg addtransaction(TransactionDto transactionDto){
            String email=transactionDto.getEmail();
            float amount=transactionDto.getAmount();
            String balance=transactionDto.getBalance();
            UserEntity user=userrepo.findByEmail(email);
         

            if(balance.equals("debit")){
                if(user.getTotalWealth()<amount){
                    return new TransactionMsg(null,"You don't have enough balance in your account to make this transaction");
                  }
                user.setTotalWealth(user.getTotalWealth()-amount);
            }
            else{
                user.setTotalWealth(user.getTotalWealth()+amount);
            }
            userrepo.save(user);
            transactionrepo.save(modelMapper.map(transactionDto,TransactionEntity.class));

            return new TransactionMsg(transactionDto,"ok");

        }
        public List<TransactionDto> gettransaction(String email){
            
            List<TransactionEntity>li=transactionrepo.findByEmail(email);

          return   li.stream()
            .map(transac->modelMapper.map(transac,TransactionDto.class))
            .collect(Collectors.toList());

        }
        
}
