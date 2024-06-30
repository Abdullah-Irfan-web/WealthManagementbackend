package com.example.wealthmanagement.WealthService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.wealthmanagement.Msg.StockMsg;
import com.example.wealthmanagement.WealthDto.StockDto;
import com.example.wealthmanagement.WealthEntities.StockEntity;
import com.example.wealthmanagement.WealthEntities.UserEntity;
import com.example.wealthmanagement.WealthRepo.Stockrepositories;
import com.example.wealthmanagement.WealthRepo.Userrepositories;

@Service
public class Stockservice {

            final Stockrepositories stockrepo;
            final ModelMapper modelMapper;
            final Userrepositories userrepo;
            public Stockservice(Userrepositories userrepo,Stockrepositories stockrepo, ModelMapper modelMapper) {
                this.stockrepo = stockrepo;
                this.modelMapper = modelMapper;
                this.userrepo=userrepo;
            }
            
            public List<StockDto> getstock(String email){
                List<StockEntity>li=stockrepo.findByEmail(email);
                 return li.stream().map(stock->modelMapper.map(stock,StockDto.class))
    .collect(Collectors.toList());

            }
            public StockMsg addstock(StockDto stockDto){

                UserEntity user=userrepo.findByEmail(stockDto.getEmail());

                if(user.getTotalWealth()<(stockDto.getPrice()*stockDto.getQuantity())){
                    return new StockMsg(stockDto,"Do not have enough fund");
                }
                user.setTotalWealth(user.getTotalWealth()-(stockDto.getPrice()*stockDto.getQuantity()));
                userrepo.save(user);
                stockrepo.save(modelMapper.map(stockDto,StockEntity.class));

                return new StockMsg(null, "ok");

            }
            public StockMsg sellstock(int id,float pl,String email){
                UserEntity user=userrepo.findByEmail(email);
                Optional<StockEntity> st=stockrepo.findById(id);
              
                if(pl<0){
                user.setTotalWealth(user.getTotalWealth() +((st.get().getPrice()*st.get().getQuantity())-pl));    
                }
                else{
                    user.setTotalWealth(user.getTotalWealth() +((st.get().getPrice()*st.get().getQuantity())+pl));    
              
                }
                stockrepo.deleteById(id);
                userrepo.save(user);
                return new StockMsg(null,"ok");
            }


}
