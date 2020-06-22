package com.ogur.airlines.controller;

import com.ogur.airlines.model.Company;
import com.ogur.airlines.service.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@Controller
public class CompanyController
{
    @Autowired
    private CompanyService companyService;

    @PostMapping("/company")
    public ResponseEntity<Company> addCompany(@RequestBody Company company)
    {
        Company addedCompany = companyService.addCompany(company);
        log.info("Added company info = {} ", addedCompany );
        return new ResponseEntity<>( addedCompany, HttpStatus.OK );  // after add company to database return  full company information
    }

    @GetMapping("/company/{id}")
    public ResponseEntity<Optional<Company>> findCompany( @PathVariable(value = "id") Integer id)
    {
        Optional<Company> company= companyService.findCompanyById(id); // after find company from database return full company information
        log.info("Searched company info = {} ", company );
        return new ResponseEntity<>(company, HttpStatus.OK );
    }
}
