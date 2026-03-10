package com.urwolfram.GymTracker.services;

import com.urwolfram.GymTracker.entities.ExerciseEntity;

import java.util.List;
import java.util.Optional;

public interface ExerciseService {


    List<ExerciseEntity> findAll();

    ExerciseEntity createExercise(ExerciseEntity exerciseEntity);

    Optional<ExerciseEntity> findExercise(Integer id);

    void delete(Integer id);
}
