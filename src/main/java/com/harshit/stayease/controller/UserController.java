package com.harshit.stayease.controller;

import com.harshit.stayease.dto.UserRequestDto;
import com.harshit.stayease.dto.UserResponseDto;
import com.harshit.stayease.service.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UserController.APPLICATION_ENDPOINT)
public class UserController {
    protected static final String APPLICATION_ENDPOINT = "/stayease/api/v1";
    private static final String USER_ENDPOINT = "users";

    @Autowired
    private IUserService userService;


    @PostMapping(USER_ENDPOINT+"/register")
    public ResponseEntity<UserResponseDto> addExam(@RequestBody @Valid UserRequestDto userRequestDto){
        return ResponseEntity.ok().body(userService.createUser(userRequestDto));
    }

    @GetMapping(USER_ENDPOINT)
    public ResponseEntity<List<UserResponseDto>> getUsers(){
        return ResponseEntity.ok().body(userService.findAllUsers());
    }

    @GetMapping(USER_ENDPOINT+"/{id}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable long id){
        return ResponseEntity.ok().body(userService.findUserById(id));
    }

    @PutMapping(USER_ENDPOINT+"/{id}")
    public ResponseEntity<UserResponseDto> updateUserById(@PathVariable long id, @RequestBody @Valid UserRequestDto userRequestDto){
        return ResponseEntity.ok().body(userService.updateUserById(id,userRequestDto));

    }
    @DeleteMapping(USER_ENDPOINT+"/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable long id){
        userService.deleteUserById(id);
        return ResponseEntity.ok().body("Deleted Successfully");

    }


}
