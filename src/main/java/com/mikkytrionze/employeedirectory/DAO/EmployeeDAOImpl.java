package com.mikkytrionze.employeedirectory.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mikkytrionze.employeedirectory.contract.Person;
import com.mikkytrionze.employeedirectory.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAOImpl implements IPersonDAO {
    private EntityManager _entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this._entityManager = entityManager;
    }

    @Override
    public List<Person> findAll() {
        
        // create a query
        String _queryCommand = "FROM Employee";
        TypedQuery<Employee> _query = this._entityManager.createQuery(_queryCommand, Employee.class);

        // fetch the data
        List<Person> _data = new ArrayList<Person>();
        for(Employee emp: _query.getResultList()) {
            _data.add(emp);
        }
        return _data;
    }

    public boolean addPerson(Employee _Employee) {
        var person = this._entityManager.merge(_Employee);
        return person != null;
    }

    public Employee findPersonById(int _EmployeeId) {
        var person = this._entityManager.find(Employee.class, _EmployeeId);
        return person;
    }

    public boolean updatePerson(int _EmployeeId, Employee _Employee) {
        var person = (Employee)this.findPersonById(_EmployeeId);

        if (person != null) {
            person.setFirstname(_Employee.getFirstname());
            person.setLastname(_Employee.getLastname());
            person.setEmailAddress(_Employee.getEmailAddress());
            this._entityManager.merge(person);
            return true;
        } 
        
        return false;
    }

    public boolean deletePerson(int _EmployeeId) {
        var employee = (Employee)this.findPersonById(_EmployeeId);

        if (employee != null) {
            this._entityManager.remove(employee);
            return true;
        } 
        
        return false;
    }
}
