package com.example.wealthmanagement.WealthService;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.wealthmanagement.Msg.StockMsg;
import com.example.wealthmanagement.WealthDto.StockDto;
import com.example.wealthmanagement.WealthEntities.StockEntity;
import com.example.wealthmanagement.WealthRepo.Stockrepositories;

@Service
public class Stockservice {

            final Stockrepositories stockrepo;
            final ModelMapper modelMapper;
            public Stockservice(Stockrepositories stockrepo, ModelMapper modelMapper) {
                this.stockrepo = stockrepo;
                this.modelMapper = modelMapper;
            }
            
            public List<StockDto> getstock(String email){
                List<StockEntity>li=stockrepo.findByEmail(email);
                 return li.stream().map(stock->modelMapper.map(stock,StockDto.class))
    .collect(Collectors.toList());

            }
            public StockMsg addstock(StockDto stockDto){
                stockrepo.save(modelMapper.map(stockDto,StockEntity.class));

                return new StockMsg(null, "ok");

            }
            public StockMsg sellstock(int id){
                stockrepo.deleteById(id);
                return new StockMsg(null,"ok");
            }


}
