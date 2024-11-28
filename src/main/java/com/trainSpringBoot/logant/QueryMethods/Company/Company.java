package com.trainSpringBoot.logant.QueryMethods.Company;

import com.trainSpringBoot.logant.QueryMethods.Manager.Manager;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;
    private String address;
    private String phoneNumber;
    private String emailAddress;
    private String websiteAddress;
    private String socialMediaLinks;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "manager_id", referencedColumnName = "id")
    private Manager manager;
}
