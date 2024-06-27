package com.example.wealthmanagement.WealthRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.wealthmanagement.WealthEntities.UserEntity;



@Repository
public interface Userrepositories extends JpaRepository<UserEntity,Integer> {

    UserEntity findByEmail(String email);
}
