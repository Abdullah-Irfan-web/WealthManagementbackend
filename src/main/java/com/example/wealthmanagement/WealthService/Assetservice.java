package com.example.wealthmanagement.WealthService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.wealthmanagement.Msg.AssetMsg;
import com.example.wealthmanagement.WealthDto.AssetDto;
import com.example.wealthmanagement.WealthEntities.AssetEntity;
import com.example.wealthmanagement.WealthEntities.UserEntity;
import com.example.wealthmanagement.WealthRepo.Assetrepositories;
import com.example.wealthmanagement.WealthRepo.Userrepositories;

@Service
public class Assetservice {
    public Assetservice(Assetrepositories assetrepo,Userrepositories Userrepo, ModelMapper modelMapper) {
        Assetrepo = assetrepo;
        this.Userrepo=Userrepo;
        this.modelMapper = modelMapper;
    }
    final Assetrepositories Assetrepo;
    final Userrepositories Userrepo;
    final ModelMapper modelMapper;


    public AssetMsg addasset(AssetDto assetDto){

        if(assetDto.getName().equals("Real Estate")){
            if(assetDto.getValue()<200000){
                return new AssetMsg(assetDto,"Value for Real Estate is less");
            }
        }
        if(assetDto.getName().equals("Vehicle")){
            if(assetDto.getValue()<70000){
                return new AssetMsg(assetDto,"Value for Vehicle is less");
            }
        }

           UserEntity user= Userrepo.findByEmail(assetDto.getEmail());
           if(user.getTotalWealth()<assetDto.getValue()){
            return new AssetMsg(assetDto,"Do not have enough balance to buy asset");
           
           }
           user.setTotalWealth(user.getTotalWealth()-assetDto.getValue());
           Userrepo.save(user);
        

        Assetrepo.save(modelMapper.map(assetDto,AssetEntity.class));

        return new AssetMsg(assetDto,"ok");

    }
    public AssetMsg deleteasset(int id){
        Optional<AssetEntity> asset=Assetrepo.findById(id);

      String email=asset.get().getEmail();
      UserEntity user= Userrepo.findByEmail(email);
      user.setTotalWealth(user.getTotalWealth()+asset.get().getValue());
      Userrepo.save(user);
        Assetrepo.deleteById(id);
        return new AssetMsg(null,"ok");

    }

    public AssetMsg updateasset(AssetDto assetDto){
    
        if(assetDto.getName().equals("Real Estate")){
            if(assetDto.getValue()<200000){
                return new AssetMsg(assetDto,"Value for Real Estate is less");
            }
        }
        if(assetDto.getName().equals("Vehicle")){
            if(assetDto.getValue()<70000){
                return new AssetMsg(assetDto,"Value for Vehicle is less");
            }
        }
        Optional<AssetEntity> asset=Assetrepo.findById(assetDto.getId());
        float orgprice=asset.get().getValue();
        UserEntity user= Userrepo.findByEmail(assetDto.getEmail());
        if(orgprice>=assetDto.getValue()){
            float diff=orgprice-assetDto.getValue();
           user.setTotalWealth(user.getTotalWealth()+diff);
        }
        else{
            float diff=assetDto.getValue()-orgprice;
            if(user.getTotalWealth()<diff){
                return new AssetMsg(assetDto,"Do not have enough balance to buy asset");
               
               }
               user.setTotalWealth(user.getTotalWealth()-diff);

        }
          
          
         

           Userrepo.save(user);

       Assetrepo.save(modelMapper.map(assetDto,AssetEntity.class));
       return new AssetMsg(null,"ok");
    }

    public List<AssetDto> getasset(String email){
       
        List<AssetEntity> li=Assetrepo.findByEmail(email);
        System.out.println(li);
         return li.stream().map(assetent->modelMapper.map(assetent,AssetDto.class))
    .collect(Collectors.toList());

    }


}
