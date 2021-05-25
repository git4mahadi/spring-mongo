package com.edu.javatechbd.springmongo.controller;

import com.edu.javatechbd.springmongo.entity.Student;
import com.edu.javatechbd.springmongo.model.StudentDTO;
import com.edu.javatechbd.springmongo.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;


    @PostMapping("/student")
    public void createNewStudent(@RequestBody StudentDTO student) {
        studentService.createNewStudent(student);
    }


    @GetMapping("/student/id/{studentId}")
    public Student getStudentById(@PathVariable String studentId) {
        return studentService.getStudentById(studentId)
                .orElse(new Student());
    }


    @PutMapping("/student/id/{studentId}")
    public void updateStudentInfo(@PathVariable String studentId,
                                  @RequestBody StudentDTO student) {
        studentService.updateStudent(studentId, student);
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }


    @DeleteMapping("/student/id/{studentId}")
    public void deleteStudentById(@PathVariable String studentId) {
        studentService.deleteStudentById(studentId);
    }


    @GetMapping("/students/pageNo/{pageNo}/pageSize/{pageSize}")
    public List<Student> getAllWithPagination(@PathVariable int pageNo,
                                              @PathVariable int pageSize) {
        return studentService.getAllStudentsWithPagination(pageNo, pageSize);
    }


    @GetMapping("/students/departmentName/{departmentName}")
    public List<Student> getAllStudentByDepartmentName(@PathVariable String departmentName) {
        return studentService.getAllStudentByDepartmentName(departmentName);
    }


    @GetMapping("/students/subject-name/{subjectName}")
    public List<Student> getAllStudentsBySubjectName(@PathVariable String subjectName) {
        return studentService.findBySubjectsSubjectSubjectName(subjectName);
    }


}
