package com.edu.javatechbd.springmongo.config;

import com.edu.javatechbd.springmongo.entity.Student;
import com.edu.javatechbd.springmongo.entity.StudentAdmissionEntity;
import com.edu.javatechbd.springmongo.entity.Subject;
import com.edu.javatechbd.springmongo.repository.StudentAdmissionRepository;
import com.edu.javatechbd.springmongo.repository.StudentRepository;
import com.edu.javatechbd.springmongo.repository.SubjectRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentAdmissionConfig {

  @Bean
  CommandLineRunner commandLineRunner(StudentAdmissionRepository studentAdmissionRepository,
                                      SubjectRepository subjectRepository,
                                      StudentRepository studentRepository) {
    return args -> {
      var student = new Student();
      student.setName("mahadi");
      student = studentRepository.save(student);

      List<Subject> subjects = List.of(new Subject("subject1"), new Subject("subject2"));
      subjects = subjectRepository.saveAll(subjects);

      var entity = new StudentAdmissionEntity();
      entity.setAdmissionDate(LocalDate.now());
      entity.setStudent(student);
      entity.setSubjects(subjects);
      studentAdmissionRepository.save(entity);


      studentAdmissionRepository.findById("640abb3968ae7e6989935d51").ifPresent(itm-> {
        System.out.println(itm);
      });


    };
  }

}
