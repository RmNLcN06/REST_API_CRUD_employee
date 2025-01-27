package com.rmnlcn.REST_API_CRUD_employee.services;

import com.rmnlcn.REST_API_CRUD_employee.entities.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    List<Employee> findAll();
}
