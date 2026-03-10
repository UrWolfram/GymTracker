package com.urwolfram.GymTracker.services.impl;

import com.urwolfram.GymTracker.entities.ExerciseEntity;
import com.urwolfram.GymTracker.repositories.ExerciseRepository;
import com.urwolfram.GymTracker.services.ExerciseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExerciseServiceImpl implements ExerciseService {

    private ExerciseRepository exerciseRepository;

    public ExerciseServiceImpl(ExerciseRepository exerciseRepository){
        this.exerciseRepository = exerciseRepository;
    }

    @Override
    public List<ExerciseEntity> findAll() {
        return exerciseRepository.findAll();
    }

    @Override
    public ExerciseEntity createExercise(ExerciseEntity exerciseEntity) {
        return exerciseRepository.save(exerciseEntity);
    }

    @Override
    public Optional<ExerciseEntity> findExercise(Integer id) {
        return exerciseRepository.findById(id);
    }

    @Override
    public void delete(Integer id) {
        exerciseRepository.deleteById(id);
    }
}
