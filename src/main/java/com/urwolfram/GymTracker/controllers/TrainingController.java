package com.urwolfram.GymTracker.controllers;

import com.urwolfram.GymTracker.dto.TrainingDto;
import com.urwolfram.GymTracker.entities.ExerciseEntity;
import com.urwolfram.GymTracker.entities.TrainingEntity;
import com.urwolfram.GymTracker.mappers.Mapper;
import com.urwolfram.GymTracker.services.TrainingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TrainingController {

    private Mapper<TrainingEntity, TrainingDto> trainingMapper;
    private TrainingService trainingService;

    public TrainingController(TrainingService trainingService, Mapper<TrainingEntity, TrainingDto> trainingMapper){
        this.trainingService = trainingService;
        this.trainingMapper = trainingMapper;
    }

    @PostMapping("/trainings")
    public TrainingDto addTraining(@RequestBody TrainingDto trainingDto){
        TrainingEntity trainingEntity = trainingMapper.mapFrom(trainingDto);
        TrainingEntity savedTrainingEntity = trainingService.addTraining(trainingEntity, trainingDto);
        return trainingMapper.mapTo(savedTrainingEntity);
    }

    @GetMapping(path = "/trainings/{userId}")
    public List<TrainingDto> getTrainingsByUserId(@PathVariable Integer userId){
        List<TrainingEntity> trainings = trainingService.getTrainingsByUserId(userId);

        return trainings.stream().map(trainingMapper::mapTo).collect(Collectors.toList());

    }


}
