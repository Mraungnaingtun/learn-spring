package com.trainSpringBoot.logant.Relationship.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String street;
    private String houseNumber;
    private String zipCode;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

}
