package com.example.wealthmanagement.WealthService;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.wealthmanagement.Msg.LiabilityMsg;
import com.example.wealthmanagement.WealthDto.LiabilityDto;
import com.example.wealthmanagement.WealthEntities.LiabilityEntity;
import com.example.wealthmanagement.WealthRepo.Liabilityrepositories;

@Service
public class Liabilityservice {

    final ModelMapper modelMapper;
    final Liabilityrepositories Liabilityrepo;
    public Liabilityservice(ModelMapper modelMapper, Liabilityrepositories liabilityrepo) {
        this.modelMapper = modelMapper;
        Liabilityrepo = liabilityrepo;
    }

    public LiabilityMsg addliability(LiabilityDto liabilityDto){

            Liabilityrepo.save(modelMapper.map(liabilityDto,LiabilityEntity.class));

                return new LiabilityMsg(liabilityDto,"ok");
    }

     public LiabilityMsg deleteliability(int id){
        Liabilityrepo.deleteById(id);
        return new LiabilityMsg(null,"ok");

    }

    public LiabilityMsg updateliability(LiabilityDto liabilityDto){
       Liabilityrepo.save(modelMapper.map(liabilityDto,LiabilityEntity.class));
       return new LiabilityMsg(null,"ok");
    }

    public List<LiabilityDto> getliability(String email){
       
        List<LiabilityEntity> li=Liabilityrepo.findByEmail(email);
        
         return li.stream().map(liabilityent->modelMapper.map(liabilityent,LiabilityDto.class))
    .collect(Collectors.toList());

    }




    
}
