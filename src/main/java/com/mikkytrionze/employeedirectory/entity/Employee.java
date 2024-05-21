package com.mikkytrionze.employeedirectory.entity;

import org.springframework.beans.factory.annotation.Autowired;

import com.mikkytrionze.employeedirectory.contract.Person;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee extends Person {

    // define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int Id;

    @Column(name = "first_name")
    private String firstname;

    @Column(name = "last_name")
    private String lastname;

    @Column(name = "email")
    private String emailAddress;

    // define constructors
    public Employee() {
    }

    @Autowired
    public Employee(String firstName, String lastName, String emailAddress) {
        this.emailAddress = emailAddress;
        this.firstname = firstName;
        this.lastname = lastName;
    }

    // define setters and getters
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "Employee [Id="
                + Id + ", firstname="
                + firstname + ", lastname="
                + lastname + ", emailAddress="
                + emailAddress + "]";
    }

    // define toString

}
