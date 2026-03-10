package com.urwolfram.GymTracker.controllers;

import com.urwolfram.GymTracker.entities.ExerciseEntity;
import com.urwolfram.GymTracker.services.ExerciseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ExerciseController {

    private ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService){
        this.exerciseService = exerciseService;
    }

    @GetMapping("/exercises")
    public List<ExerciseEntity> listExercises(){
        List<ExerciseEntity> exercises= exerciseService.findAll();
        return exercises;
    }

    @GetMapping(path = "/exercises/{id}")
    public ResponseEntity<ExerciseEntity> getExercise(@PathVariable ("id") Integer id){
        Optional<ExerciseEntity> foundExercise = exerciseService.findExercise(id);
        return foundExercise.map(exerciseEntity -> {
            return new ResponseEntity<>(exerciseEntity, HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/exercises")
    public ExerciseEntity addExercise(@RequestBody ExerciseEntity exerciseEntity){
        return exerciseService.createExercise(exerciseEntity);
    }

    @DeleteMapping(path = "/exercises/{id}")
    public ResponseEntity deleteExercise(@PathVariable("id") Integer id){
        exerciseService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
