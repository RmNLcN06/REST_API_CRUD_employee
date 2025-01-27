package com.rmnlcn.REST_API_CRUD_employee.services;

import com.rmnlcn.REST_API_CRUD_employee.daos.EmployeeDAO;
import com.rmnlcn.REST_API_CRUD_employee.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    // Set up constructor injection
    @Autowired
    public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO) {
        employeeDAO = theEmployeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return List.of();
    }
}
