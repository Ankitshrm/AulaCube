package com.aulacube.services;

import com.aulacube.models.Department;

import java.util.List;

public interface DepartmentService {
    Department createDepartment(Department department);

    List<Department> getAllDepartments();

    Department getDepartmentById(String id);

    Department updateDepartment(String id, Department updatedDepartment);

    void deleteDepartment(String id);
}
