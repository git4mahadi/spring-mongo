package com.edu.javatechbd.springmongo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Transient;

@Data
@ToString
public class SubjectMark {

    @Transient
    private String subjectId;
    private Subject subject;
    private Double obtainMarks;

    public SubjectMark(Subject subject, Double obtainMarks) {
        this.subjectId = subject.getId();
        this.subject = subject;
        this.obtainMarks = obtainMarks;
    }

    public SubjectMark() {
    }
}
