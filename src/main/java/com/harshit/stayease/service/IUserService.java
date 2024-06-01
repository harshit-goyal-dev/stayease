package com.harshit.stayease.service;

import com.harshit.stayease.dto.UserRequestDto;
import com.harshit.stayease.dto.UserResponseDto;
import com.harshit.stayease.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService {

    UserDetailsService userDetailsService();
    public List<UserResponseDto> findAllUsers();

    public UserResponseDto createUser(UserRequestDto userRequestDto);

    public UserResponseDto findUserById(long id);

    public  UserResponseDto updateUserById(long id, UserRequestDto userRequestDto);

    public  User updateUser(User user);

    public void deleteUserById(long id);

    public User getUserById(long id);


}
