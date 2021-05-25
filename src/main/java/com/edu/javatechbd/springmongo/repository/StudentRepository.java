package com.edu.javatechbd.springmongo.repository;

import com.edu.javatechbd.springmongo.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

    List<Student> findAllByDepartment_DepartmentName(String departmentName);
    List<Student> findAllByDepartmentDepartmentName(String departmentName);
    List<Student> findBySubjectsObtainMarks(double obtainMarks);
    List<Student> findBySubjectsSubjectSubjectName(String subjectName);
}
