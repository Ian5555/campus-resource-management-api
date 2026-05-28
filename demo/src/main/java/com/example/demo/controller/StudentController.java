package com.example.demo.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
// This is the controller for the student. It has endpoints for getting all students and adding a new student. It uses a dynamic array list to store the students, which allows the API to add new students when it gets a request.
@RestController
@RequestMapping("/api/students")

public class StudentController {
// Dynamic array list to store the students. This allows the API to add new students when it gets a request.
    private List<Student> students = new ArrayList<>();
// Endpoints for the API. The GET endpoint allows the API to send a response with all the students 
    @GetMapping
    public List<Student> getAllStudents() {
        return students;
    }
// The POST endpoint allows the API to add a new student when it gets a request.
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        students.add(student);
        return student;
    }
}
