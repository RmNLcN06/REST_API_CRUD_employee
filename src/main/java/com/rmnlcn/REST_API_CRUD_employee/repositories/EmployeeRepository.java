package com.rmnlcn.REST_API_CRUD_employee.repositories;

import com.rmnlcn.REST_API_CRUD_employee.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// @RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
