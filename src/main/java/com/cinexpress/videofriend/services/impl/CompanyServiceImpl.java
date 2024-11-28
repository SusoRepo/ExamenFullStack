package com.cinexpress.videofriend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinexpress.videofriend.models.Company;
import com.cinexpress.videofriend.repository.CompanyRepository;
import com.cinexpress.videofriend.services.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService{

    @Autowired
    CompanyRepository companyRepository;

    @Override
    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }

    @Override
    public void updateCompany(Long id, Company company) {
        companyRepository.save(company);
    }
    
}
