package com.example.wealthmanagement.WealthRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.wealthmanagement.WealthEntities.AssetEntity;



@Repository
public interface Assetrepositories extends JpaRepository<AssetEntity,Integer> {

    List<AssetEntity> findByEmail(String email);
} 
