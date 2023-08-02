package com.example.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.user.entity.FinancialInstitution;

@Repository
public interface FinancialInstitutionRepo extends JpaRepository<FinancialInstitution, Integer>{

}
