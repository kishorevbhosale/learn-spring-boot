package com.msk.mongodb.service;

import com.msk.mongodb.model.Employee;
import com.msk.mongodb.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    // Get all employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Get employee by ID
    public Optional<Employee> getEmployeeById(String id) {
        return employeeRepository.findById(id);
    }

    // Add new employee
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Update an employee
    public Employee updateEmployee(String id, Employee employeeDetails) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);

        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            employee.setName(employeeDetails.getName());
            employee.setDepartment(employeeDetails.getDepartment());
            employee.setSalary(employeeDetails.getSalary());
            return employeeRepository.save(employee);
        } else {
            throw new RuntimeException("Employee not found");
        }
    }

    // Delete an employee
    public void deleteEmployee(String id) {
        employeeRepository.deleteById(id);
    }
}
