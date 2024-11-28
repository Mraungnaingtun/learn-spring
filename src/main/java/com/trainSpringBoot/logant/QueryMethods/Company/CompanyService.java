package com.trainSpringBoot.logant.QueryMethods.Company;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trainSpringBoot.logant.Projections.CompanySummary;
import com.trainSpringBoot.logant.QueryMethods.Manager.Manager;
import com.trainSpringBoot.logant.QueryMethods.Manager.ManagerRepo;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final ManagerRepo managerRepository;

    public CompanyService(CompanyRepository companyRepository, ManagerRepo managerRepository) {
        this.companyRepository = companyRepository;
        this.managerRepository = managerRepository;
    }

    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    public Page<Company> getItems(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return companyRepository.findAll(pageable);
    }

    public Company findById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    public Company save(Company company) {
        if (company.getManager() != null) {
            Manager manager =  managerRepository.save(company.getManager());
            company.setManager(manager);
        }
        return companyRepository.save(company);
    }

    // @Transactional
    // public String saveMock500(Company company) {
    // try {
    // for (int i = 0; i < 500; i++) {
    // Company newCompany = new Company();
    // newCompany.setCompanyName(company.getCompanyName() + i);
    // newCompany.setAddress(company.getAddress());
    // newCompany.setEmailAddress(company.getEmailAddress() + i + "@email.com");
    // newCompany.setPhoneNumber(company.getPhoneNumber() + i);
    // newCompany.setSocialMediaLinks(company.getSocialMediaLinks());
    // newCompany.setWebsiteAddress(company.getWebsiteAddress());
    // companyRepository.save(newCompany);
    // }
    // return "Saved!";
    // } catch (Exception e) {
    // e.printStackTrace(); // Log the exception
    // return "Error: " + e.getMessage();
    // }
    //
    // }

    public void deleteById(Long id) {
        companyRepository.deleteById(id);
    }

    public Company getCompanyByName(String name) {
        return companyRepository.findByCompanyNameIgnoreCase(name);
    }

    public Company getCompanyNameAndWebsiteAddress(String cname, String webAddress) {
        return companyRepository.findByCompanyNameAndWebsiteAddressAllIgnoreCase(cname, webAddress);
    }


    public List<CompanySummary> getCustomerByName(String name){
        return companyRepository.findByCompanyName(name);
    }

    @Transactional
    public int updatePhoneNumber(String newNumber, String oldNumber) {
        return companyRepository.updatePhoneNumber(newNumber, oldNumber);
    }
}
