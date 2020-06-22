package com.ogur.airlines.service;

import com.ogur.airlines.model.Company;

import java.util.Optional;

public interface CompanyService
{
     Company addCompany( Company company );
     Optional<Company> findCompanyById(Integer id);
}
