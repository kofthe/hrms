package com.mehmetari.hrms.repository;

import com.mehmetari.hrms.entity.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerRepository extends JpaRepository<Employer, Integer> {
}
