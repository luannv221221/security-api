package com.ra.controller;

import com.ra.model.dto.UserLoginDTO;
import com.ra.model.dto.UserRegisterDTO;
import com.ra.service.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    @Autowired
    private AuthService authService;
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginDTO userLoginDTO){

        return new ResponseEntity<>(authService.login(userLoginDTO), HttpStatus.OK);

    }
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserRegisterDTO userRegisterDTO){
        return new ResponseEntity<>(authService.register(userRegisterDTO),HttpStatus.CREATED);
    }
}
