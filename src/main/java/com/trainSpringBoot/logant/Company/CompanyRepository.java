package com.trainSpringBoot.logant.Company;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;

import com.trainSpringBoot.logant.Projections.CompanySummary;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long>{

    Company findByCompanyNameIgnoreCase(String name);
    Company findByCompanyNameAndWebsiteAddressAllIgnoreCase(String companyname, String websiteddress);
    Streamable<Company> findByCompanyNameOrderByCompanyNameAsc(String name);


    //find by Projections
    List<CompanySummary> findByCompanyName(String name);
}


