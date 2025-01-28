package com.rmnlcn.REST_API_CRUD_employee.repositories;

import com.rmnlcn.REST_API_CRUD_employee.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
