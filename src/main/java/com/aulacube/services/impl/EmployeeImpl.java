package com.aulacube.services.impl;

import com.aulacube.exceptions.ResourceNotFoundException;
import com.aulacube.models.Department;
import com.aulacube.models.Employee;
import com.aulacube.repositories.EmployeeRepository;
import com.aulacube.services.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class EmployeeImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public Employee registerEmployee(Employee employee) {
        employee.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return this.employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No such employee found"));
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Long id,Employee updatedEmployee ) {
        Employee existingEmployee = getEmployeeById(id);
        existingEmployee.setFirstName(updatedEmployee.getFirstName());
        existingEmployee.setLastName(updatedEmployee.getLastName());
        existingEmployee.setEmail(updatedEmployee.getEmail());
        existingEmployee.setDepartmentId(updatedEmployee.getDepartmentId());
        existingEmployee.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        return employeeRepository.save(existingEmployee);
    }

    @Override
    public void removeEmployee(Long id) {
        Employee emp = this.employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No such employee"));
        this.employeeRepository.delete(emp);
    }
}
