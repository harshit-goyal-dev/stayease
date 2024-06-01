package com.harshit.stayease.controller;

import com.harshit.stayease.dto.JwtAuthenticationResponse;
import com.harshit.stayease.dto.SignInRequest;
import com.harshit.stayease.service.IAuthenticationService;
import com.harshit.stayease.dto.JwtAuthenticationResponse;
import com.harshit.stayease.dto.SignInRequest;
import com.harshit.stayease.service.IAuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(AuthenticationController.APPLICATION_ENDPOINT)
public class AuthenticationController {
    protected static final String APPLICATION_ENDPOINT = "/stayease/api/v1";
    private static final String SIGNIN_ENDPOINT = "login";

    @Autowired
    private IAuthenticationService authenticationService;


    @PostMapping(SIGNIN_ENDPOINT)
    public ResponseEntity<JwtAuthenticationResponse> addExam(@RequestBody @Valid SignInRequest signInRequest){
        return ResponseEntity.ok().body(authenticationService.signin(signInRequest));
    }
}
