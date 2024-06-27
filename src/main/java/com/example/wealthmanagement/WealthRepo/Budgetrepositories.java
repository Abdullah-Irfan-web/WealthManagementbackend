package com.example.wealthmanagement.WealthRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.wealthmanagement.WealthEntities.BudgetEntity;

@Repository
public interface Budgetrepositories extends JpaRepository<BudgetEntity,Integer> {
    List<BudgetEntity> findByEmail(String email);
   
}
