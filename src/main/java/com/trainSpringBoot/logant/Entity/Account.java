package com.trainSpringBoot.logant.Entity;

import com.trainSpringBoot.logant.Base.BaseEntity;
import com.trainSpringBoot.logant.Enum.AccountType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Account extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accountHolderName;
    private String accountNumber;
    private Double balance;
    
    @Enumerated(EnumType.STRING)
    private AccountType accountType;


}
