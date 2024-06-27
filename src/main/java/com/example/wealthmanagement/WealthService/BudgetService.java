package com.example.wealthmanagement.WealthService;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.wealthmanagement.Msg.BudgetMsg;
import com.example.wealthmanagement.WealthDto.BudgetDto;
import com.example.wealthmanagement.WealthEntities.BudgetEntity;
import com.example.wealthmanagement.WealthRepo.Budgetrepositories;

@Service

public class BudgetService {
        private Budgetrepositories budgetrepo;
        private ModelMapper modelMapper;
        public BudgetService(Budgetrepositories budgetrepo, ModelMapper modelMapper) {
            this.budgetrepo = budgetrepo;
            this.modelMapper = modelMapper;
        }
       

        public BudgetMsg addbudget(BudgetDto budgetDto){

            budgetrepo.save(modelMapper.map(budgetDto,BudgetEntity.class));

            return new BudgetMsg(budgetDto,"ok");


        }
        
        public BudgetMsg updatebudget(BudgetDto budgetDto){

            budgetrepo.save(modelMapper.map(budgetDto,BudgetEntity.class));

            return new BudgetMsg(null,"ok");


        }
        public BudgetMsg update(String type,String email,int amount, String balance){

             List<BudgetEntity>li=   budgetrepo.findByEmail(email);
            String msg="";
             for(BudgetEntity x:li){
                if(x.getName().equals(type)){
                    int a=x.getAmount();
                    if(balance.equals("credit")){
                        System.out.println(balance);
                        x.setAmount(a+amount);
                    }
                    else{
                        System.out.println(balance);
                        x.setAmount(a-amount);
                    }
                   
                    budgetrepo.save(x);
                    
                    msg="ok";
                    break;
                }
             }
             return new BudgetMsg(null,msg);

        }

        public List<BudgetDto> getbudget(String email){

            List<BudgetEntity>li=budgetrepo.findByEmail(email);
            return li.stream()
            .map(budget->modelMapper.
            map(budget,BudgetDto.class)).collect(Collectors.toList());
            
        }


}
