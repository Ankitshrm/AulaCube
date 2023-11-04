package com.aulacube.services.impl;

import com.aulacube.exceptions.ResourceNotFoundException;
import com.aulacube.models.Department;
import com.aulacube.repositories.DepartmentRepository;
import com.aulacube.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.sql.Timestamp;
import java.util.List;

@Service
public class DepartmentImpl implements DepartmentService{

        @Autowired
        private DepartmentRepository departmentRepository;

        public List<Department> getAllDepartments() {
            return departmentRepository.findAll();
        }

        public Department getDepartmentById(String id) {
            return departmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + id));
        }

        public Department createDepartment(Department department) {
            department.setCreatedAt(new Timestamp(System.currentTimeMillis()));
            return departmentRepository.save(department);
        }

        public Department updateDepartment(String id, Department updatedDepartment) {
            Department existingDepartment = getDepartmentById(id);
            existingDepartment.setDepartmentName(updatedDepartment.getDepartmentName());
            existingDepartment.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
            return departmentRepository.save(existingDepartment);
        }

        public void deleteDepartment(String id) {
            Department dep = departmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + id));
            this.departmentRepository.delete(dep);
        }


}
