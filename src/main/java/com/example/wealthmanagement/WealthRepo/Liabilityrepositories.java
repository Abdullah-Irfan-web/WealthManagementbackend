package com.example.wealthmanagement.WealthRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.wealthmanagement.WealthEntities.LiabilityEntity;

@Repository
public interface Liabilityrepositories extends JpaRepository<LiabilityEntity,Integer> {

        List<LiabilityEntity> findByEmail(String email);
} 
