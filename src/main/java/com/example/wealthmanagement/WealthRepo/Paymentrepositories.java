package com.example.wealthmanagement.WealthRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.wealthmanagement.WealthEntities.PaymentEntity;

@Repository
public interface Paymentrepositories extends JpaRepository<PaymentEntity,Integer>{

        List<PaymentEntity> findByEmailfrom(String emailfrom);
        List<PaymentEntity> findByEmailto(String emailto);
}
