package com.mikkytrionze.employeedirectory.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mikkytrionze.employeedirectory.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
