package com.urwolfram.GymTracker.controllers;

import com.urwolfram.GymTracker.dto.UserDto;
import com.urwolfram.GymTracker.entities.UserEntity;
import com.urwolfram.GymTracker.mappers.Mapper;
import com.urwolfram.GymTracker.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class UserController {

    private UserService userService;
    private Mapper<UserEntity, UserDto> userMapper;

    public UserController(UserService userService, Mapper<UserEntity, UserDto> userMapper){
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping(path = "/users")
    public List<UserDto> listUsers(){
        List<UserEntity> usersD = userService.findAll();
        return usersD.stream()
                .map(userMapper::mapTo)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/users/{id}")
    public ResponseEntity<UserEntity> getUser(@PathVariable ("id") Integer id){
        Optional<UserEntity> foundUser =  userService.findOne(id);
        return foundUser.map(userEntity -> {
            return new ResponseEntity<>(userEntity, HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(path = "/users")
    public UserDto createUser(@RequestBody UserDto userDto){
        UserEntity userEntity = userMapper.mapFrom(userDto);
        UserEntity savedUserEntity = userService.saveUser(userEntity);
        return userMapper.mapTo(savedUserEntity);
    }

    @PutMapping(path = "/users/{id}")
    public ResponseEntity<UserDto> partialUpdateUser(
            @PathVariable("id") Integer id, @RequestBody UserDto userDto){
        if(!userService.isExists(id)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else{
            UserEntity userEntity = userMapper.mapFrom(userDto);
            UserEntity updatedUserEntity = userService.partialUpdate(id, userEntity);
            return new ResponseEntity<>(userMapper.mapTo(updatedUserEntity), HttpStatus.OK);
        }

    }

    @DeleteMapping(path = "/users/{id}")
    public ResponseEntity deleteUser(@PathVariable("id") Integer id){
        userService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
