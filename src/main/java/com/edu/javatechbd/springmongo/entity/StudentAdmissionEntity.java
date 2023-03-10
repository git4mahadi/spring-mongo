package com.edu.javatechbd.springmongo.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document(collection = "studentAdmission")
@Data
@ToString
public class StudentAdmissionEntity {

  @Id
  private String id;

  private LocalDate admissionDate;

  @DBRef
  private Student student;

  @DBRef
  private List<Subject> subjects;


}
