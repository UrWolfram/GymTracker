package com.urwolfram.GymTracker.mappers.impl;

import com.urwolfram.GymTracker.dto.TrainingDto;
import com.urwolfram.GymTracker.entities.TrainingEntity;
import com.urwolfram.GymTracker.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.lang.constant.ModuleDesc;

@Component
public class TrainingMapperImpl implements Mapper<TrainingEntity, TrainingDto> {

    @Override
    public TrainingDto mapTo(TrainingEntity entity) {
        TrainingDto dto = new TrainingDto();

        dto.setUserId(entity.getUser().getId());
        dto.setExerciseId(entity.getExercise().getId());
        dto.setWeight(entity.getWeight());
        dto.setReps(entity.getReps());

        return dto;
    }

    @Override
    public TrainingEntity mapFrom(TrainingDto dto) {
        TrainingEntity entity = new TrainingEntity();

        entity.setWeight(dto.getWeight());
        entity.setReps(dto.getReps());

        return entity;
    }
}
