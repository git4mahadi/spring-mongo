package com.edu.javatechbd.springmongo.repository;

import com.edu.javatechbd.springmongo.entity.StudentAdmissionEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentAdmissionRepository extends MongoRepository<StudentAdmissionEntity, String> {


}
