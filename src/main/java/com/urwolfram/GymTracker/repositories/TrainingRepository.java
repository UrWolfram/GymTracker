package com.urwolfram.GymTracker.repositories;

import com.urwolfram.GymTracker.entities.TrainingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainingRepository extends JpaRepository<TrainingEntity, Long> {
    List<TrainingEntity> findByUserId(Integer userId);
}
