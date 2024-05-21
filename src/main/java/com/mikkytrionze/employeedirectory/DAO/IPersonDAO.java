package com.mikkytrionze.employeedirectory.DAO;

import java.util.List;

import com.mikkytrionze.employeedirectory.contract.Person;

public interface IPersonDAO {
    public List<Person> findAll();
    
}
