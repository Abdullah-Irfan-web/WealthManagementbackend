package com.example.wealthmanagement.WealthService;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.wealthmanagement.Msg.TransactionMsg;
import com.example.wealthmanagement.WealthDto.TransactionDto;
import com.example.wealthmanagement.WealthEntities.TransactionEntity;
import com.example.wealthmanagement.WealthRepo.Transactionrepositories;

@Service
public class Transactionservice {
        final Transactionrepositories transactionrepo;
        final ModelMapper modelMapper;
        public Transactionservice(Transactionrepositories transactionrepo, ModelMapper modelMapper) {
            this.transactionrepo = transactionrepo;
            this.modelMapper = modelMapper;
        }


        public TransactionMsg addtransaction(TransactionDto transactionDto){

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
