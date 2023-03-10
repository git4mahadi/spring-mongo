package com.edu.javatechbd.springmongo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "students")
@Data
@ToString
public class Student {

    @Id
    private String id;
    private String name;
    @Field(name = "email")
    private String email;
    private String mobile;
//    @DBRef(lazy = true)
    @DBRef
//    @JsonIgnore
    private Department department;
    private List<SubjectMark> subjects;
}
