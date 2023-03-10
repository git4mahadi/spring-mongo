package com.edu.javatechbd.springmongo.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "departments")
@Data
@ToString
public class Department {

    @Id
    private String id;
    private String departmentCode;
    private String departmentName;

    //@PersistenceConstructor

}
