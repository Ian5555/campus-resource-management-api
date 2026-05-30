package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Student;
// This is the repository for the student. It extends JpaRepository, which provides basic CRUD operations for the student. It also allows us to use the database to store the students instead of a dynamic array list in the controller.
public interface StudentRepository extends JpaRepository<Student, Integer> {
    
}
