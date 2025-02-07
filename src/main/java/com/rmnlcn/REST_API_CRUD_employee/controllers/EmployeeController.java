package com.rmnlcn.REST_API_CRUD_employee.controllers;

import com.rmnlcn.REST_API_CRUD_employee.entities.Employee;
import com.rmnlcn.REST_API_CRUD_employee.services.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    // add mapping for "/list"
    @GetMapping("/list")
    public String listEmployees(Model theModel) {

        // get employees from db
        List<Employee> theEmployees = employeeService.findAll();

        // add to spring model
        theModel.addAttribute("employees", theEmployees);

        return "list-employees";
    }
}
