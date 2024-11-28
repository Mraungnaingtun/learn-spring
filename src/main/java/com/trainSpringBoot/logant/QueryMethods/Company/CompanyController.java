package com.trainSpringBoot.logant.QueryMethods.Company;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trainSpringBoot.logant.Projections.CompanySummary;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public List<Company> getAllCompanies() {
        return companyService.findAll();
    }

    @GetMapping("/items")
    public Page<Company> getItems(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return companyService.getItems(page, size);
    }

    @GetMapping("/byName")
    public ResponseEntity<Company> getByName(@RequestParam(name = "name")  String param) {
        return ResponseEntity.ok(companyService.getCompanyByName(param));
    }

    @GetMapping("/search")
    public ResponseEntity<?> getByCompanyNameAndWebsite(@RequestParam String company, @RequestParam String website) {
        // return
        // ResponseEntity<>(companyService.getCompanyNameAndWebsiteAddress(company,website),HttpStatus.OK);
        return ResponseEntity.status(HttpStatus.OK)
                .body(companyService.getCompanyNameAndWebsiteAddress(company, website));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id) {
        Company company = companyService.findById(id);
        if (company != null) {
            return ResponseEntity.ok(company);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Projections Example
    @GetMapping("/getByName")
    public List<CompanySummary> getMethodName(@RequestParam String name) {
        return companyService.getCustomerByName(name);
    }

    @PostMapping
    public Company createCompany(@RequestBody Company company) {
        return companyService.save(company);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Company> updateCompany(@PathVariable Long id, @RequestBody Company companyDetails) {
        Company company = companyService.findById(id);
        if (company != null) {
            company.setCompanyName(companyDetails.getCompanyName());
            company.setAddress(companyDetails.getAddress());
            company.setPhoneNumber(companyDetails.getPhoneNumber());
            company.setEmailAddress(companyDetails.getEmailAddress());
            company.setWebsiteAddress(companyDetails.getWebsiteAddress());
            company.setSocialMediaLinks(companyDetails.getSocialMediaLinks());
            return ResponseEntity.ok(companyService.save(company));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable Long id) {
        if (companyService.findById(id) != null) {
            companyService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/phone")
    public ResponseEntity<?> updatePhone(@RequestBody Map<String, String> req) {
        return ResponseEntity.ok(
                companyService.updatePhoneNumber(req.getOrDefault("newNumber", ""), req.getOrDefault("oldNumber", "")));
    }

}