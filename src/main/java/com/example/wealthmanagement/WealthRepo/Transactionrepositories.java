package com.example.wealthmanagement.WealthRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.wealthmanagement.WealthEntities.TransactionEntity;


@Repository
public interface Transactionrepositories extends JpaRepository<TransactionEntity,Integer> {
    List<TransactionEntity> findByEmail(String email);
   
}
