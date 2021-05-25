package com.edu.javatechbd.springmongo.controller;

import com.edu.javatechbd.springmongo.entity.Subject;
import com.edu.javatechbd.springmongo.service.SubjectService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class SubjectController {

    private final SubjectService subjectService;



    @PostMapping("/subject")
    public void createNewSubject(@RequestBody Subject subject) {
        subjectService.createSubject(subject);
    }


    @PutMapping("/subject/id/{subjectId}")
    public void updateSubject(@PathVariable String subjectId,
                                 @RequestBody Subject department) {
        subjectService.updateSubject(subjectId, department);
    }


    @GetMapping("/subject/id/{subjectId}")
    public Subject getSubjectInfById(@PathVariable String subjectId) {
        return subjectService.getSubjectById(subjectId)
                .orElse(new Subject());
    }


    @GetMapping("/subjects")
    public List<Subject> getSubjectList() {
        return subjectService.getAllSubjects();
    }


    @DeleteMapping("/subject/id/{subjectId}")
    public void deleteBySubjectId(@PathVariable String subjectId) {
        subjectService.deleteSubjectById(subjectId);
    }
}
