package com.mikkytrionze.employeedirectory.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mikkytrionze.employeedirectory.contract.Person;
import com.mikkytrionze.employeedirectory.contract.httpresponse.ErrorResponse;
import com.mikkytrionze.employeedirectory.contract.httpresponse.NotFoundException;
import com.mikkytrionze.employeedirectory.entity.Employee;
import com.mikkytrionze.employeedirectory.service.EmployeeServiceImpl;
import com.mikkytrionze.employeedirectory.service.IPersonService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    // inject employee dao
    private IPersonService personService;

    public EmployeeRestController(EmployeeServiceImpl _EmployeeServiceImpl) {
        this.personService = _EmployeeServiceImpl;
    }

    /// expose eploee employee endpoints

    @GetMapping("/employee/")
    public List<Employee> findAll() {
        List<Employee> result = new ArrayList<Employee>();
        for(Person emp: this.personService.findAll()) {
            result.add((Employee)emp);
        }
        return result;
    }

    @GetMapping("/employee/{_EmployeeId}/")
    public Employee findEmployee(@PathVariable int _EmployeeId) {
        return this.personService.findEmployee(_EmployeeId);
    }

    @PostMapping("/employee/")
    public boolean addEmployee(@RequestBody Employee _Employee) {
        _Employee.setId(0);
        return this.personService.addEmployee(_Employee);
    }

    @PutMapping("/employee/{_EmployeeId}/")
    public boolean updateEmployee(@PathVariable int _EmployeeId, @RequestBody Employee _Employee) {
        return this.personService.updateEmployee(_EmployeeId, _Employee);
    }

    @DeleteMapping("/employee/{_EmployeeId}/")
    public boolean deleteEmployee(@PathVariable int _EmployeeId) {
        return this.personService.deleteEmployee(_EmployeeId);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(NotFoundException exception) {
        ErrorResponse _ErrorResponse = new ErrorResponse(
            HttpStatus.NOT_FOUND.value(), 
            exception.getMessage(), 
            System.currentTimeMillis());

        return new ResponseEntity<>(_ErrorResponse, HttpStatus.NOT_FOUND);
    }
}
