package com.edu.javatechbd.springmongo.service;

import com.edu.javatechbd.springmongo.entity.Student;
import com.edu.javatechbd.springmongo.entity.SubjectMark;
import com.edu.javatechbd.springmongo.model.StudentDTO;
import com.edu.javatechbd.springmongo.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentService {

    private final DepartmentService departmentService;
    private final StudentRepository studentRepository;
    private final SubjectService subjectService;


    @Transactional
    public void createNewStudent(StudentDTO studentDTO) {
        Student student = new ModelMapper().map(studentDTO, Student.class);
        student.setId(null);
        departmentService.findDepartmentById(studentDTO.getDepartmentId())
                .ifPresent(department-> {
                    student.setDepartment(department);
                });

        student.setSubjects(studentDTO.getSubjectMarkList().stream()
        .map(subject-> new SubjectMark(subjectService.getSubjectById(subject.getSubjectId()).orElseThrow(),
                subject.getObtainMarks()))
        .collect(Collectors.toList()));

        studentRepository.save(student);
    }


    public Optional<Student> getStudentById(String id) {
        return studentRepository.findById(id);
    }


    public void updateStudent(String studentId, StudentDTO studentDTO) {
        studentRepository.findById(studentId).ifPresent(student-> {
            student.setName(studentDTO.getName());
            student.setEmail(studentDTO.getEmail());
            student.setMobile(studentDTO.getMobile());
            departmentService.findDepartmentById(studentDTO.getDepartmentId())
                    .ifPresent(department-> {
                        student.setDepartment(department);
                    });
            student.setSubjects(studentDTO.getSubjectMarkList().stream()
                    .map(subject-> new SubjectMark(subjectService.getSubjectById(subject.getSubjectId()).orElseThrow(),
                            subject.getObtainMarks()))
                    .collect(Collectors.toList()));

            studentRepository.save(student);
        });
    }


    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }


    public void deleteStudentById(String id) {
        studentRepository.deleteById(id);
    }


    public List<Student> getAllStudentsWithPagination(int pageNo, int pageSize) {
//        Sort sort = Sort.by(Sort.Direction.ASC, "name");
        Sort sort = Sort.by(Sort.Direction.ASC, "name", "email");
//        Pageable pageable = PageRequest.of(pageNo-1, pageSize);
        Pageable pageable = PageRequest.of(pageNo-1, pageSize, sort);
        return studentRepository.findAll(pageable).getContent();
    }

    public List<Student> getAllStudentByDepartmentName(String departmentName) {
        return studentRepository.findAllByDepartment_DepartmentName(departmentName);
    }


    public List<Student> findBySubjectsSubjectSubjectName(String subjectName) {
        return studentRepository.findBySubjectsSubjectSubjectName(subjectName);
    }



}
