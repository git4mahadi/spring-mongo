package com.edu.javatechbd.springmongo.controller;

import com.edu.javatechbd.springmongo.entity.Department;
import com.edu.javatechbd.springmongo.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping("/department")
    public void createNewDepartment(@RequestBody Department department) {
        departmentService.createDepartment(department);
    }


    @PutMapping("/department/id/{departmentId}")
    public void updateDepartment(@PathVariable String departmentId,
                                 @RequestBody Department department) {
        departmentService.updateDepartment(departmentId, department);
    }


    @GetMapping("/department/id/{departmentId}")
    public Department getDepartmentInfById(@PathVariable String departmentId) {
        return departmentService.findDepartmentById(departmentId)
                .orElse(new Department());
    }


    @GetMapping("/departments")
    public List<Department> getDepartmentList() {
        return departmentService.getAllDepartments();
    }


    @DeleteMapping("/department/id/{departmentId}")
    public void deleteByDepartmentId(@PathVariable String departmentId) {
        departmentService.deleteByDepartmentId(departmentId);
    }
}
