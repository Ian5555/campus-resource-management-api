package com.example.demo.model;
// This is the model for the student. It has an id, name, major, and target role.
public class Student {
    private int id;
    private String name;
    private String major;
    private String targetrole;
// Constructor builds the student when the API gets a request.
    public Student(int id, String name, String major, String targetrole) {
        this.id = id;
        this.name = name;
        this.major = major;
        this.targetrole = targetrole;

    }
// Getters allow the API to access the student information when it needs to send a response.
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }

    public String getTargetRole() {
        return targetrole;
    }
}
