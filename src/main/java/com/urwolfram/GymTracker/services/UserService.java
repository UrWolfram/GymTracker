package com.urwolfram.GymTracker.services;

import com.urwolfram.GymTracker.entities.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public List<UserEntity> findAll();

    UserEntity saveUser(UserEntity userEntity);

    Optional<UserEntity> findOne(Integer id);

    boolean isExists(Integer id);

    UserEntity partialUpdate(Integer id, UserEntity userEntity);

    void delete(Integer id);
}
