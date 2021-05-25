package com.edu.javatechbd.springmongo.service;

import com.edu.javatechbd.springmongo.entity.Department;
import com.edu.javatechbd.springmongo.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;


    public void createDepartment(Department department) {
        departmentRepository.save(department);
    }


    public void updateDepartment(String departmentId, Department department) {
        departmentRepository.findById(departmentId).ifPresent(update-> {
            update.setDepartmentCode(department.getDepartmentCode());
            update.setDepartmentName(department.getDepartmentName());
            departmentRepository.save(update);
        });
    }


    public Optional<Department> findDepartmentById(String id) {
        return departmentRepository.findById(id);
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }


    public void deleteByDepartmentId(String id) {
        departmentRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Department not found with id: "+id));
        departmentRepository.deleteById(id);
    }
}
