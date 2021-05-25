package com.edu.javatechbd.springmongo.repository;

import com.edu.javatechbd.springmongo.entity.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends MongoRepository<Department, String> {
}
