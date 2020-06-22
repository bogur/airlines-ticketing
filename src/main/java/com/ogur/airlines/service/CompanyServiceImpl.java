package com.ogur.airlines.service;

import com.ogur.airlines.repository.CompanyRepository;
import com.ogur.airlines.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService
{
    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Company addCompany(Company company)
    {
        return companyRepository.save(company);
    }

    @Override
    public Optional<Company> findCompanyById(Integer id)
    {
        return companyRepository.findById( id );
    }

}
