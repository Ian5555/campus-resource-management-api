package com.example.demo.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    // The PUT endpoint allows the API to update a student when it gets a request. It takes the id of the student to update and the updated student information in the request body. It then updates the student in the list and returns the updated student.
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student updatedStudent) {
        // Loop through the list of students to find the student with the matching id.
        for(int i = 0; i < students.size(); i++) {
                if(students.get(i).getId() == id) {
                    // If we find the new student replace with new one and return the updated student.
                    students.set(i, updatedStudent);
                    return updatedStudent;
                }
            }
            return null; // If we don't find the student with the matching id, return null. 
        }
        // The DELETE endpoint allows the API to delete a student when it gets a request. It takes the id of the student to delete in the request body. It then deletes the student from the list and returns a success message.
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        // Loop through the list of students to find the student with the matching id.
        for(int i = 0; i < students.size(); i++) {
                if(students.get(i).getId() == id) {
                    // If we find the student, remove it from the list and return a success message.
                    students.remove(i);
                    return "Student with id " + id + " deleted successfully.";
                }
            }
            return "Student with id " + id + " not found."; // If we don't find the student with the matching id, return a not found message.


    }


}
