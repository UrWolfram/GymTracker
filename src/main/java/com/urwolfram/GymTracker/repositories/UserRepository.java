package com.urwolfram.GymTracker.repositories;

import com.urwolfram.GymTracker.entities.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository extends CrudRepository<UserEntity, Integer> {
}
