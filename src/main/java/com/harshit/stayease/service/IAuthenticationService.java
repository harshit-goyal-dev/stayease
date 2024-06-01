package com.harshit.stayease.service;

import com.harshit.stayease.dto.JwtAuthenticationResponse;
import com.harshit.stayease.dto.SignInRequest;
import com.harshit.stayease.dto.UserRequestDto;
import com.harshit.stayease.entity.User;

public interface IAuthenticationService {
    User signUp(UserRequestDto userRequestDto);
    JwtAuthenticationResponse signin(SignInRequest signInRequest);
}
