package com.urwolfram.GymTracker.dto;

import com.urwolfram.GymTracker.entities.ExerciseEntity;
import com.urwolfram.GymTracker.entities.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TrainingDto {
    private Integer userId;
    private Integer exerciseId;

    private Double weight;
    private Integer reps;
}
