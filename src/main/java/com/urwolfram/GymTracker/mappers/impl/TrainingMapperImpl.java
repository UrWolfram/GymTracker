package com.urwolfram.GymTracker.mappers.impl;

import com.urwolfram.GymTracker.dto.TrainingDto;
import com.urwolfram.GymTracker.entities.TrainingEntity;
import com.urwolfram.GymTracker.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.lang.constant.ModuleDesc;

@Component
public class TrainingMapperImpl implements Mapper<TrainingEntity, TrainingDto> {

    private ModelMapper modelMapper;

    public TrainingMapperImpl(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    @Override
    public TrainingDto mapTo(TrainingEntity trainingEntity) {
        return modelMapper.map(trainingEntity, TrainingDto.class);
    }

    @Override
    public TrainingEntity mapFrom(TrainingDto trainingDto) {
        return modelMapper.map(trainingDto, TrainingEntity.class);

    }
}
