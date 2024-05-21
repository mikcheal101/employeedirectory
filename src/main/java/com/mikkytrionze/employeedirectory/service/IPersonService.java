package com.mikkytrionze.employeedirectory.service;

import java.util.List;
import com.mikkytrionze.employeedirectory.contract.Person;
import com.mikkytrionze.employeedirectory.entity.Employee;

public interface IPersonService {
    List<Person> findAll();

    Employee findEmployee(int _EmployeeId);
    boolean addEmployee(Employee _Employee);
    boolean updateEmployee(int _EmployeeId, Employee _Employee);
    boolean deleteEmployee(int _EmployeeId);
}
