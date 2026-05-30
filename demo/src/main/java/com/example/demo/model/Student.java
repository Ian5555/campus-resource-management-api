package com.example.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
 
@Entity // Tells spring boot "make a database table for this class"

// This is the model for the student. It has an id, name, major, and target role.
public class Student {
    @Id // Tells spring boot "This is the primary key for the database table"
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Tells spring boot "Automatically generate a unique id for each student"
    private Integer id;
    private String name;
    private String major;
    private String targetRole;

    // A real database requires a no-argument constructor, so we include one here. It doesn't do anything, but it's necessary for the database to work properly.
    public Student() {
    }

   

// Constructor builds the student when the API gets a request.
    public Student(Integer id, String name, String major, String targetRole) {
        this.id = id;
        this.name = name;
        this.major = major;
        this.targetRole = targetRole;
    }
// Getters allow the API to access the student information when it needs to send a response.
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }

    public String getTargetRole() {
        return targetRole;
    }
// Setters allow the API to update the student information when it gets a request to update a student.
    public void setId(Integer id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setMajor(String major) {
        this.major = major;
    }
    public void setTargetRole(String targetRole) {
        this.targetRole = targetRole;
    }
}
