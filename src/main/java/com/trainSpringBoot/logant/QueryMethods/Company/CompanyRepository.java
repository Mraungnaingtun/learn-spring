package com.trainSpringBoot.logant.QueryMethods.Company;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;

import com.trainSpringBoot.logant.Projections.CompanySummary;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    Company findByCompanyNameIgnoreCase(String name);

    Company findByCompanyNameAndWebsiteAddressAllIgnoreCase(String companyname, String websiteddress);

    Streamable<Company> findByCompanyNameOrderByCompanyNameAsc(String name);

    // find by Projections
    List<CompanySummary> findByCompanyName(String name);

    @Modifying // entity manager to be cleared automatically
    @Query("update Company c set c.phoneNumber = ?1 where c.phoneNumber = ?2")
    int updatePhoneNumber(String newNumber, String oldNumber);
}
