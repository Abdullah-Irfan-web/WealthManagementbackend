package com.example.wealthmanagement.WealthRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.wealthmanagement.WealthEntities.StockEntity;


@Repository
public interface Stockrepositories extends JpaRepository<StockEntity,Integer> {

    List<StockEntity> findByEmail(String email);
    
} 
