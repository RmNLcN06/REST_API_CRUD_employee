package com.rmnlcn.REST_API_CRUD_employee.services;

// import com.rmnlcn.REST_API_CRUD_employee.daos.EmployeeDAO;
import com.rmnlcn.REST_API_CRUD_employee.entities.Employee;
import com.rmnlcn.REST_API_CRUD_employee.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    // Work with DAO
    //private EmployeeDAO employeeDAO;

    // Work with repository : Use EmployeeRepository
    private EmployeeRepository employeeRepository;

    // Set up constructor injection
    @Autowired
    public EmployeeServiceImpl(
            /*EmployeeDAO theEmployeeDAO*/
            EmployeeRepository theEmployeeRepository
    ) {
        //employeeDAO = theEmployeeDAO;
        employeeRepository = theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        // return employeeDAO.findAll();
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
        // return employeeDAO.findById(theId);
        Optional<Employee> result = employeeRepository.findById(theId);
        Employee theEmployee = null;

        if(result.isPresent()) {
            theEmployee = result.get();
        }
        else
        {
            throw new RuntimeException("Did not find employee id - " + theId);
        }
        return theEmployee;
    }

    //@Transactional : No need with JpaRespository because provides this functionality
    @Override
    public Employee save(Employee theEmployee) {
        // return employeeDAO.save(theEmployee);
        return employeeRepository.save(theEmployee);
    }

    //@Transactional : No need with JpaRespository because provides this functionality
    @Override
    public void deleteById(int theId) {
        // employeeDAO.deleteById(theId);
        employeeRepository.deleteById(theId);
    }
}
