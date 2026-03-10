package com.urwolfram.GymTracker.repositories;

import com.urwolfram.GymTracker.entities.ExerciseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ExerciseRepository extends JpaRepository<ExerciseEntity, Integer> {
}
