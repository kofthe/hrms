package com.mehmetari.hrms.repository;

import com.mehmetari.hrms.entity.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerRepository extends JpaRepository<Employer, Integer> {

    boolean existsEmployerByEmail(String email);

    boolean existsEmployerByCompanyEmail(String companyEmail);

}
