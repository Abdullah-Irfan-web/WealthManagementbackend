package com.example.wealthmanagement.WealthService;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.wealthmanagement.Msg.AssetMsg;
import com.example.wealthmanagement.WealthDto.AssetDto;
import com.example.wealthmanagement.WealthEntities.AssetEntity;
import com.example.wealthmanagement.WealthRepo.Assetrepositories;

@Service
public class Assetservice {
    public Assetservice(Assetrepositories assetrepo, ModelMapper modelMapper) {
        Assetrepo = assetrepo;
        this.modelMapper = modelMapper;
    }
    final Assetrepositories Assetrepo;
    final ModelMapper modelMapper;


    public AssetMsg addasset(AssetDto assetDto){


        Assetrepo.save(modelMapper.map(assetDto,AssetEntity.class));
        return new AssetMsg(assetDto,"ok");

    }
    public AssetMsg deleteasset(int id){
        Assetrepo.deleteById(id);
        return new AssetMsg(null,"ok");

    }

    public AssetMsg updateasset(AssetDto assetDto){
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
