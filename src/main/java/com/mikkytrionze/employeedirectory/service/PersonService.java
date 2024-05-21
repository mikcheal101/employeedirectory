package com.mikkytrionze.employeedirectory.service;

import com.mikkytrionze.employeedirectory.DAO.IPersonDAO;

public abstract class PersonService implements IPersonService {
    protected IPersonDAO _IPersonDAO;
}
