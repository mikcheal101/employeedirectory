package com.mikkytrionze.employeedirectory.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mikkytrionze.employeedirectory.contract.Person;
import com.mikkytrionze.employeedirectory.entity.Employee;
import com.mikkytrionze.employeedirectory.repo.EmployeeRepository;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl extends PersonService {
    
    private EmployeeRepository _EmployeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        _EmployeeRepository = employeeRepository;
    }

    @Override
    public List<Person> findAll() {
        var persons = new ArrayList<Person>();
        for(Person p: _EmployeeRepository.findAll()) {
            persons.add(p);
        }
        return persons;
    }

    @Override
    public Employee findEmployee(int _EmployeeId) {

        Optional<Employee> dataset = _EmployeeRepository.findById(_EmployeeId);
        Employee employee = null;

        if (dataset.isPresent()) {
            employee = dataset.get();
        } 
        else {
            throw new RuntimeException("Did not find the employee id...");
        }

        return employee;
    }

    @Transactional
    @Override
    public boolean addEmployee(Employee _Employee) {
        var employee = _EmployeeRepository.save(_Employee);
        return employee != null;
    }

    @Transactional
    @Override
    public boolean updateEmployee(int _EmployeeId, Employee _Employee) {
        var employee = findEmployee(_EmployeeId);

        if (employee != null) {
            _Employee.setId(employee.getId());
            employee = _EmployeeRepository.save(_Employee);
        }
        
        return employee != null;
    }

    @Transactional
    @Override
    public boolean deleteEmployee(int _EmployeeId) {
        var employee = findEmployee(_EmployeeId);

        if (employee != null) {
            _EmployeeRepository.delete(employee);
            return true;
        }
        return false;
    }
}
