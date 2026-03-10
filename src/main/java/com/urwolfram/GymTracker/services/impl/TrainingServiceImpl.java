package com.urwolfram.GymTracker.services.impl;

import com.urwolfram.GymTracker.dto.TrainingDto;
import com.urwolfram.GymTracker.entities.ExerciseEntity;
import com.urwolfram.GymTracker.entities.TrainingEntity;
import com.urwolfram.GymTracker.entities.UserEntity;
import com.urwolfram.GymTracker.repositories.ExerciseRepository;
import com.urwolfram.GymTracker.repositories.TrainingRepository;
import com.urwolfram.GymTracker.repositories.UserRepository;
import com.urwolfram.GymTracker.services.TrainingService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TrainingServiceImpl implements TrainingService {

    private TrainingRepository trainingRepository;
    private ExerciseRepository exerciseRepository;
    private UserRepository userRepository;

    public TrainingServiceImpl(TrainingRepository trainingRepository, ExerciseRepository exerciseRepository, UserRepository userRepository){
        this.trainingRepository = trainingRepository;
        this.exerciseRepository = exerciseRepository;
        this.userRepository = userRepository;
    }


    @Override
    public TrainingEntity addTraining(TrainingEntity trainingEntity, TrainingDto dto) {

        UserEntity user = userRepository.findById(dto.getUserId()).orElseThrow();
        ExerciseEntity exercise = exerciseRepository.findById(dto.getExerciseId()).orElseThrow();

        trainingEntity.setUser(user);
        trainingEntity.setExercise(exercise);
        trainingEntity.setDate(LocalDateTime.now());
        return trainingRepository.save(trainingEntity);
    }
}
