package com.edu.javatechbd.springmongo.model;

import com.edu.javatechbd.springmongo.entity.SubjectMark;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class StudentDTO {

    private String name;
    private String email;
    private String mobile;
    private String departmentId;
    private List<SubjectMark> subjectMarkList;
}
