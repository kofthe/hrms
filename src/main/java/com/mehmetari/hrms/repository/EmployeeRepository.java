package com.mehmetari.hrms.repository;

import com.mehmetari.hrms.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
