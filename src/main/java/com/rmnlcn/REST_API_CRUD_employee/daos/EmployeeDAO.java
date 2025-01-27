package com.rmnlcn.REST_API_CRUD_employee.daos;

import com.rmnlcn.REST_API_CRUD_employee.entities.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
