package com.example.demo.model;

public class Workout {
    private int id;
    private String name;
    private int duration;
    private String date;

    public Workout(int id, String name, int duration, String date) {
        this.id = id;
        this.name = name;
        this.duration = duration; 
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public String getDate() {
        return date;
    }
}
