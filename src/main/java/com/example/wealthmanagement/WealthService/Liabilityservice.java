package com.example.wealthmanagement.WealthService;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.wealthmanagement.Msg.LiabilityMsg;
import com.example.wealthmanagement.WealthDto.LiabilityDto;
import com.example.wealthmanagement.WealthEntities.LiabilityEntity;
import com.example.wealthmanagement.WealthEntities.UserEntity;
import com.example.wealthmanagement.WealthRepo.Liabilityrepositories;
import com.example.wealthmanagement.WealthRepo.Userrepositories;

@Service
public class Liabilityservice {

    final ModelMapper modelMapper;
    final Liabilityrepositories Liabilityrepo;
    final Userrepositories Userrepo;
    public Liabilityservice(ModelMapper modelMapper, Liabilityrepositories liabilityrepo,Userrepositories Userrepo) {
        this.modelMapper = modelMapper;
        Liabilityrepo = liabilityrepo;
        this.Userrepo=Userrepo;
    }

    public LiabilityMsg addliability(LiabilityDto liabilityDto){
         if(liabilityDto.getName().equals("Car Loan")){
            if(liabilityDto.getValue()<100000){
                return new LiabilityMsg(liabilityDto,"Car Loan Amount is less");
            }
        }
        if(liabilityDto.getName().equals("Mortgage")){
            if(liabilityDto.getValue()<500000){
                return new LiabilityMsg(liabilityDto,"Mortage Amount is less");
            }
        }
        if(liabilityDto.getName().equals("Education Loan")){
            if(liabilityDto.getValue()<100000){
                return new LiabilityMsg(liabilityDto,"Education Loan Amount is less");
            }
        }
        if(liabilityDto.getName().equals("Personal Loan")){
            if(liabilityDto.getValue()<100000){
                return new LiabilityMsg(liabilityDto,"Personal Loan Amount is less");
            }
        }

           UserEntity user= Userrepo.findByEmail(liabilityDto.getEmail());
           if(user.getTotalWealth()<50000){
            return new LiabilityMsg(liabilityDto,"Do not have enough balance in your bank to get loans");
           
           }
        
            Liabilityrepo.save(modelMapper.map(liabilityDto,LiabilityEntity.class));

                return new LiabilityMsg(liabilityDto,"ok");
    }

     public LiabilityMsg deleteliability(int id){
        Liabilityrepo.deleteById(id);
        return new LiabilityMsg(null,"ok");

    }

    public LiabilityMsg updateliability(LiabilityDto liabilityDto){

        if(liabilityDto.getName().equals("Car Loan")){
            if(liabilityDto.getValue()<100000){
                return new LiabilityMsg(liabilityDto,"Car Loan Amount is less");
            }
        }
        if(liabilityDto.getName().equals("Mortgage")){
            if(liabilityDto.getValue()<500000){
                return new LiabilityMsg(liabilityDto,"Mortage Amount is less");
            }
        }
        if(liabilityDto.getName().equals("Education Loan")){
            if(liabilityDto.getValue()<100000){
                return new LiabilityMsg(liabilityDto,"Education Loan Amount is less");
            }
        }
        if(liabilityDto.getName().equals("Personal Loan")){
            if(liabilityDto.getValue()<100000){
                return new LiabilityMsg(liabilityDto,"Personal Loan Amount is less");
            }
        }

           UserEntity user= Userrepo.findByEmail(liabilityDto.getEmail());
           if(user.getTotalWealth()<50000){
            return new LiabilityMsg(liabilityDto,"Do not have enough balance in your bank to get loans");
           
           }
       Liabilityrepo.save(modelMapper.map(liabilityDto,LiabilityEntity.class));
       return new LiabilityMsg(null,"ok");
    }

    public List<LiabilityDto> getliability(String email){
       
        List<LiabilityEntity> li=Liabilityrepo.findByEmail(email);
        
         return li.stream().map(liabilityent->modelMapper.map(liabilityent,LiabilityDto.class))
    .collect(Collectors.toList());

    }




    
}
