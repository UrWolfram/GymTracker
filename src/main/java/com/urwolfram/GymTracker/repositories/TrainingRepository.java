package com.urwolfram.GymTracker.repositories;

import com.urwolfram.GymTracker.entities.TrainingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingRepository extends JpaRepository<TrainingEntity, Long> {
}
