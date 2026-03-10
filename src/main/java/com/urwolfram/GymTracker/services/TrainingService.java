package com.urwolfram.GymTracker.services;

import com.urwolfram.GymTracker.dto.TrainingDto;
import com.urwolfram.GymTracker.entities.TrainingEntity;

public interface TrainingService {


    TrainingEntity addTraining(TrainingEntity trainingEntity, TrainingDto trainingDto);
}
