package com.example.wealthmanagement.WealthEntities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Liability")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LiabilityEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int id;
        private String email;
        private String name;
        private float value;

}
