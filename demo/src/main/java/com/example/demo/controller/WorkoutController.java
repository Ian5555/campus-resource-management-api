package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Workout;

@RestController
@RequestMapping("/api/workouts")
public class WorkoutController {

    private List<Workout> workouts = new ArrayList<>();

    @GetMapping
    public List<Workout> getAllWorkouts() {
        return workouts;
    }

    @PostMapping
    public Workout addWorkout(@RequestBody Workout workout) {
        workouts.add(workout);
        return workout;
    }
}
