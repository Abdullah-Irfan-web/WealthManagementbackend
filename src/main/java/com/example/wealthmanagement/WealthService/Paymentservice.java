package com.example.wealthmanagement.WealthService;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.wealthmanagement.Msg.PaymentMsg;
import com.example.wealthmanagement.WealthDto.PaymentDto;
import com.example.wealthmanagement.WealthEntities.PaymentEntity;
import com.example.wealthmanagement.WealthEntities.UserEntity;
import com.example.wealthmanagement.WealthRepo.Paymentrepositories;
import com.example.wealthmanagement.WealthRepo.Userrepositories;

@Service
public class Paymentservice {
final ModelMapper modelMapper;
final Paymentrepositories paymentrepo;
 public Paymentservice(ModelMapper modelMapper, Paymentrepositories paymentrepo, Userrepositories userrepo) {
    this.modelMapper = modelMapper;
    this.paymentrepo = paymentrepo;
    Userrepo = userrepo;
}
final Userrepositories Userrepo;


public PaymentMsg makepayment(PaymentDto paymentDto){

        UserEntity userfrom=Userrepo.findByEmail(paymentDto.getEmailfrom());
        UserEntity userto=Userrepo.findByEmail(paymentDto.getEmailto());

        if(userfrom.getTotalWealth()<paymentDto.getAmount()){
            return new PaymentMsg(null,"Not Enough Money In Your Accout");

        }

        if(userto==null){
            return new PaymentMsg(null,"No user exits");

        }

        userfrom.setTotalWealth(userfrom.getTotalWealth()-paymentDto.getAmount());
        userto.setTotalWealth(userto.getTotalWealth()+paymentDto.getAmount());
      paymentrepo.save(modelMapper.map(paymentDto,PaymentEntity.class));
      Userrepo.save(userfrom);
      Userrepo.save(userto);
      
        return new PaymentMsg(null,"ok");

        

       
}

 public List<PaymentDto> getpayments(String email){

    List<PaymentEntity>l1=paymentrepo.findByEmailfrom(email);
    List<PaymentEntity>l2=paymentrepo.findByEmailto(email);
    List<PaymentEntity>l3=new ArrayList<>();
    l3.addAll(l1);
    l3.addAll(l2);
    return l3.stream().map(pay->modelMapper.map(pay,PaymentDto.class))
    .collect(Collectors.toList());



 }

}
