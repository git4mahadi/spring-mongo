package com.edu.javatechbd.springmongo.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "subjects")
@Data
@ToString
public class Subject {

    @Id
    private String id;
    private String subjectName;

    public Subject(String subjectName) {
        this.subjectName = subjectName;
    }

    public Subject() {
    }

    //@PersistenceConstructor

}
