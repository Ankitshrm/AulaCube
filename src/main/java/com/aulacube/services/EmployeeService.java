package com.aulacube.services;

import com.aulacube.models.Employee;

import java.util.List;

public interface EmployeeService {

    Employee registerEmployee(Employee employeeDTO);
    Employee getEmployeeById(Long id);
    List<Employee> getAllEmployees();
    Employee updateEmployee(Long id,Employee employee);
    void removeEmployee(Long id);
}
