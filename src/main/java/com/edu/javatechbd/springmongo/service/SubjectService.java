package com.edu.javatechbd.springmongo.service;

import com.edu.javatechbd.springmongo.entity.Subject;
import com.edu.javatechbd.springmongo.repository.SubjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SubjectService {

    private final SubjectRepository subjectRepository;


    public void createSubject(Subject subject) {
        subjectRepository.save(subject);
    }

    public Optional<Subject> getSubjectById(String id) {
        return subjectRepository.findById(id);
    }


    public void updateSubject(String id, Subject subject) {
        subjectRepository.findById(id).ifPresent(update-> {
            update.setSubjectName(subject.getSubjectName());
            subjectRepository.save(update);
        });
    }


    public void deleteSubjectById(String id) {
        subjectRepository.deleteById(id);
    }

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }
}
