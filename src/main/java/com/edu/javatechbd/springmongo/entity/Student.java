package com.edu.javatechbd.springmongo.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "student")
@Data
@ToString
public class Student {

    @Id
    private String id;
    private String name;
    @Field(name = "email")
    private String email;
    private String mobile;
    private Department department;
    private List<SubjectMark> subjects;
}
