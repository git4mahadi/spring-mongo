package com.edu.javatechbd.springmongo.repository;

import com.edu.javatechbd.springmongo.entity.Subject;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends MongoRepository<Subject, String> {
}
